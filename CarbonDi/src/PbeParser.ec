#include "TokenIds.ec"
#include "Lexer.ec"

// Parser By Example - Parser

Hashmap getSpecialWords () {
    ?specialWords = Hashmap();
    specialWords.put(KEYWORD_U8, U32(TOKEN_ID_U8));
    return specialWords;
}

printf(`line-4\n`);
?content = FileUtils.fileread("langdesc.pbe");
printf(`line-3\n`);
?lex = Lexer();
printf(`line-2\n`);
?tokens = lex.lex(content, getSpecialWords());
printf(`line-1\n`);

// ?tokens = RefArrayList();

/**
Output from the lexer
*/
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
        // ?sq = sequence;
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

//********************
// printf(`line0\n`);

?ts = TokenSequence(tokens);
ts.tokenList = tokens;
ts.tsindex = 0;

?sm = SequenceMatcher();

sm.add(TokenMatcher(TOKEN_ID), 0);
sm.add(TokenMatcher(TOKEN_ASSIGN), 0);

sm.add(TokenMatcher(TOKEN_DOLLARBRACE), 0);
sm.add(TokenMatcher(TOKEN_ID), 0);
print("call match\n");
sm.add(TokenMatcher(TOKEN_RBRACE), 0);

print("call match\n");

boolean valid = sm.match(ts);

printf(`valid %u %lu\n`, valid, ts.tsindex);

// ?om = OrMatcher();
// om.add(TokenMatcher(TOKEN_ID));


