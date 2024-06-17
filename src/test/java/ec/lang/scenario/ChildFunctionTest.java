package ec.lang.scenario;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import ec.lang.BaseTest;
import ec.lang.defs.ClassDef;
import ec.lang.defs.DefFactory;
import ec.lang.defs.FunctionDef;

public class ChildFunctionTest extends BaseTest {

    String source = """
            public class Lexer.Token (Core.Object) {
                properties {
                    u64 offset;
                    u32 type;
                    String value;
                }

                public Token(=offset, =type, =value);
            }

            class Parser.TokenSequence (Object) {
                properties {
                    u64 tsindex = 0;
                    RefArrayList tokenList; // list of tokens from lexer
                }

                TokenSequence(=tokenList);
            }

            class Parser.Matcher (Object) {
                properties {
                    boolean isNot = false;
                }

                boolean match(TokenSequence tokenSequence) {
                    return false;
                }
            }

            class Parser.TokenMatcher (Parser.Matcher) {
                properties {
                    u32 tokenId;  // this token sequence ot token
                }

                TokenMatcher(=tokenId);
                TokenMatcher(=tokenId, =isNot);

                boolean match(TokenSequence tokenSequence) {
                    Token token = tokenSequence.tokenList.get(tokenSequence.tsindex);
                    print("TokenMatcher.match1 sequence=%i this=%i\n", token.type, tokenId);

                    return !isNot && token.type == tokenId;
                }
            }

            class Parser.OrMatcher (Parser.Matcher) {
                properties {
                    RefArrayList options = RefArrayList();  // what this class will match against
                }

                void add(Matcher matcher) {
                    options.add(matcher);
                }

                boolean match(TokenSequence tokenSequence) {
                    // return isNot && tokenSequence.tokenList[tokenSequence.index].token.type == tokenId;
                    return false;
                }
            }

            class Parser.SequenceMatcher (Parser.Matcher) {
                properties {
                    DynamicArray attributes = DynamicArray(20, Boxing.u8_, 1);  // required, 0-many, 1-many, not?
                    RefArrayList sequence = RefArrayList();  // what this class will match against
                }

                void add(Matcher matcher, u8 attribute) {
                    // ?sq = sequence;
                    // ?at = attributes;

                    printf(`SequenceMatcher.add %lu %u %lu %lu\n`, sequence.ralsize, attribute, attributes.length, attributes.dataSize);
                    attributes[sequence.ralsize] = attribute;
                    print("SequenceMatcher.add_1\n");
                    sequence.add(matcher);
                }

                boolean match(TokenSequence tokenSequence) {
                    print("match\n");
                    ?index = tokenSequence.tsindex;
                    ?inc = tokenSequence.tsindex;
                    print("sequence=%i\n", sequence.ralsize);
                    loop (sequence.ralsize) {
                        Matcher matcher = sequence.get($a);
                        tokenSequence.tsindex = inc;
                        if (!matcher.match(tokenSequence)) {
                            // restore index
                            tokenSequence.tsindex = index;
                            print("match false\n");
                            return false;
                        }
                        inc++;
                        print("matchinc %i\n", inc);

                    }

                    return true;
                }
            }
                                    """;

    @Test
    public void testAddMethod() {
        lex(source);

        ClassDef cd = DefFactory.resolveClass("SequenceMatcher");
        FunctionDef fd = cd.resolveFunction("match");

        String compiledCode = stripWhiteSpace(stripComments(fd.asCode()));

        assertNotNull(compiledCode);
        assertThat(compiledCode).contains("match");
    }
}
