// Generated from /home/brook/Source/ec-lang/src/main/antlr4/imports/ectypes.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ectypesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, T__92=93, T__93=94, 
		RANGE=95, ID=96, ANONYMOUS=97, NUM=98, FLOAT=99, STRING=100, CSTRING=101, 
		PRECOMPILER=102, DOC_COMMENT=103, BLOCK_COMMENT=104, LINE_COMMENT=105, 
		WS=106;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
		"T__49", "T__50", "T__51", "T__52", "T__53", "T__54", "T__55", "T__56", 
		"T__57", "T__58", "T__59", "T__60", "T__61", "T__62", "T__63", "T__64", 
		"T__65", "T__66", "T__67", "T__68", "T__69", "T__70", "T__71", "T__72", 
		"T__73", "T__74", "T__75", "T__76", "T__77", "T__78", "T__79", "T__80", 
		"T__81", "T__82", "T__83", "T__84", "T__85", "T__86", "T__87", "T__88", 
		"T__89", "T__90", "T__91", "T__92", "T__93", "RANGE", "ID", "ANONYMOUS", 
		"NUM", "FLOAT", "STRING", "CSTRING", "ESC_1", "TRIPLE_SQ", "ESC_2", "UNICODE", 
		"HEX", "NOTBACKQUOTE", "SAFECODEPOINT", "LETTER", "ALPHA", "DIGIT", "PRECOMPILER", 
		"DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "EOL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'?'", "'u8'", "'i8'", "'u16'", "'i16'", "'u32'", "'i32'", "'f32'", 
		"'u64'", "'i64'", "'f64'", "'f128'", "'f80'", "'boolean'", "'b8'", "'num'", 
		"'pointer'", "'int'", "'null'", "'<'", "'>'", "'=='", "'>='", "'<='", 
		"'!='", "'==='", "'&='", "'~='", "'||'", "'&&'", "'+='", "'*='", "'/='", 
		"'-='", "'%='", "'++'", "'--'", "'*'", "'/'", "'%'", "'+'", "'-'", "'&'", 
		"'|'", "'>>'", "'<<'", "'{'", "'}'", "'('", "')'", "'['", "']'", "';'", 
		"'='", "','", "'if'", "'!'", "'else'", "'loop'", "'public'", "'private'", 
		"'protected'", "'hidden'", "'imports'", "'is'", "'with'", "'in'", "'try'", 
		"'catch'", "'finally'", "'throws'", "'break'", "'continue'", "'switch'", 
		"'case'", "'default'", "'return'", "'return.add'", "'static'", "'final'", 
		"'void'", "'signature'", "'enum'", "'plan'", "'class'", "'properties'", 
		"'stub'", "'function'", "'=>'", "'true'", "'false'", "'namespace'", "'global'", 
		"'inline'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "RANGE", 
		"ID", "ANONYMOUS", "NUM", "FLOAT", "STRING", "CSTRING", "PRECOMPILER", 
		"DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ectypesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ectypes.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 111:
			return PRECOMPILER_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean PRECOMPILER_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return getCharPositionInLine() == 0;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2l\u037c\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\3"+
		"\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#"+
		"\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3"+
		"-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64"+
		"\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\39\3:\3:\3;\3;\3;\3;\3;\3<"+
		"\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3>\3>\3?\3?\3?\3?"+
		"\3?\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3A\3A\3A\3A\3B\3B"+
		"\3B\3C\3C\3C\3C\3C\3D\3D\3D\3E\3E\3E\3E\3F\3F\3F\3F\3F\3F\3G\3G\3G\3G"+
		"\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3J\3J\3J\3J\3J\3J"+
		"\3J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3M\3M\3M"+
		"\3N\3N\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P"+
		"\3P\3P\3Q\3Q\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3S\3S\3S\3S\3S"+
		"\3T\3T\3T\3T\3T\3U\3U\3U\3U\3U\3V\3V\3V\3V\3V\3V\3W\3W\3W\3W\3W\3W\3W"+
		"\3W\3W\3W\3W\3X\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3[\3["+
		"\3[\3[\3[\3\\\3\\\3\\\3\\\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3^\3^"+
		"\3^\3^\3^\3^\3^\3_\3_\3_\3_\3_\3_\3_\3`\3`\3`\5`\u0298\n`\3`\3`\3`\3`"+
		"\3`\3`\5`\u02a0\n`\3a\3a\7a\u02a4\na\fa\16a\u02a7\13a\3b\3b\3b\3c\5c\u02ad"+
		"\nc\3c\3c\7c\u02b1\nc\fc\16c\u02b4\13c\3c\3c\3c\3c\3c\3c\7c\u02bc\nc\f"+
		"c\16c\u02bf\13c\3c\3c\3c\3c\7c\u02c5\nc\fc\16c\u02c8\13c\5c\u02ca\nc\3"+
		"d\5d\u02cd\nd\3d\6d\u02d0\nd\rd\16d\u02d1\3d\3d\7d\u02d6\nd\fd\16d\u02d9"+
		"\13d\3d\5d\u02dc\nd\3d\7d\u02df\nd\fd\16d\u02e2\13d\3d\3d\6d\u02e6\nd"+
		"\rd\16d\u02e7\3d\5d\u02eb\nd\3d\7d\u02ee\nd\fd\16d\u02f1\13d\3d\3d\6d"+
		"\u02f5\nd\rd\16d\u02f6\5d\u02f9\nd\3d\5d\u02fc\nd\3e\3e\3e\3e\6e\u0302"+
		"\ne\re\16e\u0303\3e\3e\3e\3e\3e\6e\u030b\ne\re\16e\u030c\3e\3e\3e\6e\u0312"+
		"\ne\re\16e\u0313\3e\3e\5e\u0318\ne\3f\3f\3f\6f\u031d\nf\rf\16f\u031e\3"+
		"f\3f\3g\3g\3g\5g\u0326\ng\3h\3h\3h\3h\3i\3i\3i\5i\u032f\ni\3j\3j\3j\3"+
		"j\3j\3j\3k\3k\3l\3l\3m\3m\3n\3n\3o\3o\3p\3p\3q\3q\3q\7q\u0346\nq\fq\16"+
		"q\u0349\13q\3q\3q\3r\3r\3r\3r\3r\7r\u0352\nr\fr\16r\u0355\13r\3r\3r\3"+
		"r\3r\3r\3s\3s\3s\3s\7s\u0360\ns\fs\16s\u0363\13s\3s\3s\3s\3s\3s\3t\3t"+
		"\3t\3t\7t\u036e\nt\ft\16t\u0371\13t\3t\3t\3u\3u\3v\3v\5v\u0379\nv\3v\3"+
		"v\5\u0313\u0353\u0361\2w\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\u0087"+
		"E\u0089F\u008bG\u008dH\u008fI\u0091J\u0093K\u0095L\u0097M\u0099N\u009b"+
		"O\u009dP\u009fQ\u00a1R\u00a3S\u00a5T\u00a7U\u00a9V\u00abW\u00adX\u00af"+
		"Y\u00b1Z\u00b3[\u00b5\\\u00b7]\u00b9^\u00bb_\u00bd`\u00bfa\u00c1b\u00c3"+
		"c\u00c5d\u00c7e\u00c9f\u00cbg\u00cd\2\u00cf\2\u00d1\2\u00d3\2\u00d5\2"+
		"\u00d7\2\u00d9\2\u00db\2\u00dd\2\u00df\2\u00e1h\u00e3i\u00e5j\u00e7k\u00e9"+
		"\2\u00ebl\3\2\22\3\2c|\3\2\63;\4\2\62\63aa\3\2))\3\2$$\n\2$$\61\61^^d"+
		"dhhppttvv\n\2))\61\61^^ddhhppttvv\5\2\62;CHch\6\2\2!$$^^bb\5\2\2!$$^^"+
		"\5\2C\\aac|\6\2\62;C\\aac|\4\2\62;aa\4\2\f\f\17\17\3\2\f\f\5\2\13\13\16"+
		"\17\"\"\2\u039b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2"+
		"_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2"+
		"\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083"+
		"\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2"+
		"\2\2\u008d\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095"+
		"\3\2\2\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u009b\3\2\2\2\2\u009d\3\2\2"+
		"\2\2\u009f\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7"+
		"\3\2\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2"+
		"\2\2\u00b1\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\2\u00b7\3\2\2\2\2\u00b9"+
		"\3\2\2\2\2\u00bb\3\2\2\2\2\u00bd\3\2\2\2\2\u00bf\3\2\2\2\2\u00c1\3\2\2"+
		"\2\2\u00c3\3\2\2\2\2\u00c5\3\2\2\2\2\u00c7\3\2\2\2\2\u00c9\3\2\2\2\2\u00cb"+
		"\3\2\2\2\2\u00e1\3\2\2\2\2\u00e3\3\2\2\2\2\u00e5\3\2\2\2\2\u00e7\3\2\2"+
		"\2\2\u00eb\3\2\2\2\3\u00ed\3\2\2\2\5\u00ef\3\2\2\2\7\u00f2\3\2\2\2\t\u00f5"+
		"\3\2\2\2\13\u00f9\3\2\2\2\r\u00fd\3\2\2\2\17\u0101\3\2\2\2\21\u0105\3"+
		"\2\2\2\23\u0109\3\2\2\2\25\u010d\3\2\2\2\27\u0111\3\2\2\2\31\u0115\3\2"+
		"\2\2\33\u011a\3\2\2\2\35\u011e\3\2\2\2\37\u0126\3\2\2\2!\u0129\3\2\2\2"+
		"#\u012d\3\2\2\2%\u0135\3\2\2\2\'\u0139\3\2\2\2)\u013e\3\2\2\2+\u0140\3"+
		"\2\2\2-\u0142\3\2\2\2/\u0145\3\2\2\2\61\u0148\3\2\2\2\63\u014b\3\2\2\2"+
		"\65\u014e\3\2\2\2\67\u0152\3\2\2\29\u0155\3\2\2\2;\u0158\3\2\2\2=\u015b"+
		"\3\2\2\2?\u015e\3\2\2\2A\u0161\3\2\2\2C\u0164\3\2\2\2E\u0167\3\2\2\2G"+
		"\u016a\3\2\2\2I\u016d\3\2\2\2K\u0170\3\2\2\2M\u0173\3\2\2\2O\u0175\3\2"+
		"\2\2Q\u0177\3\2\2\2S\u0179\3\2\2\2U\u017b\3\2\2\2W\u017d\3\2\2\2Y\u017f"+
		"\3\2\2\2[\u0181\3\2\2\2]\u0184\3\2\2\2_\u0187\3\2\2\2a\u0189\3\2\2\2c"+
		"\u018b\3\2\2\2e\u018d\3\2\2\2g\u018f\3\2\2\2i\u0191\3\2\2\2k\u0193\3\2"+
		"\2\2m\u0195\3\2\2\2o\u0197\3\2\2\2q\u0199\3\2\2\2s\u019c\3\2\2\2u\u019e"+
		"\3\2\2\2w\u01a3\3\2\2\2y\u01a8\3\2\2\2{\u01af\3\2\2\2}\u01b7\3\2\2\2\177"+
		"\u01c1\3\2\2\2\u0081\u01c8\3\2\2\2\u0083\u01d0\3\2\2\2\u0085\u01d3\3\2"+
		"\2\2\u0087\u01d8\3\2\2\2\u0089\u01db\3\2\2\2\u008b\u01df\3\2\2\2\u008d"+
		"\u01e5\3\2\2\2\u008f\u01ed\3\2\2\2\u0091\u01f4\3\2\2\2\u0093\u01fa\3\2"+
		"\2\2\u0095\u0203\3\2\2\2\u0097\u020a\3\2\2\2\u0099\u020f\3\2\2\2\u009b"+
		"\u0217\3\2\2\2\u009d\u021e\3\2\2\2\u009f\u0229\3\2\2\2\u00a1\u0230\3\2"+
		"\2\2\u00a3\u0236\3\2\2\2\u00a5\u023b\3\2\2\2\u00a7\u0245\3\2\2\2\u00a9"+
		"\u024a\3\2\2\2\u00ab\u024f\3\2\2\2\u00ad\u0255\3\2\2\2\u00af\u0260\3\2"+
		"\2\2\u00b1\u0265\3\2\2\2\u00b3\u026e\3\2\2\2\u00b5\u0271\3\2\2\2\u00b7"+
		"\u0276\3\2\2\2\u00b9\u027c\3\2\2\2\u00bb\u0286\3\2\2\2\u00bd\u028d\3\2"+
		"\2\2\u00bf\u0297\3\2\2\2\u00c1\u02a1\3\2\2\2\u00c3\u02a8\3\2\2\2\u00c5"+
		"\u02c9\3\2\2\2\u00c7\u02fb\3\2\2\2\u00c9\u0317\3\2\2\2\u00cb\u0319\3\2"+
		"\2\2\u00cd\u0322\3\2\2\2\u00cf\u0327\3\2\2\2\u00d1\u032b\3\2\2\2\u00d3"+
		"\u0330\3\2\2\2\u00d5\u0336\3\2\2\2\u00d7\u0338\3\2\2\2\u00d9\u033a\3\2"+
		"\2\2\u00db\u033c\3\2\2\2\u00dd\u033e\3\2\2\2\u00df\u0340\3\2\2\2\u00e1"+
		"\u0342\3\2\2\2\u00e3\u034c\3\2\2\2\u00e5\u035b\3\2\2\2\u00e7\u0369\3\2"+
		"\2\2\u00e9\u0374\3\2\2\2\u00eb\u0378\3\2\2\2\u00ed\u00ee\7A\2\2\u00ee"+
		"\4\3\2\2\2\u00ef\u00f0\7w\2\2\u00f0\u00f1\7:\2\2\u00f1\6\3\2\2\2\u00f2"+
		"\u00f3\7k\2\2\u00f3\u00f4\7:\2\2\u00f4\b\3\2\2\2\u00f5\u00f6\7w\2\2\u00f6"+
		"\u00f7\7\63\2\2\u00f7\u00f8\78\2\2\u00f8\n\3\2\2\2\u00f9\u00fa\7k\2\2"+
		"\u00fa\u00fb\7\63\2\2\u00fb\u00fc\78\2\2\u00fc\f\3\2\2\2\u00fd\u00fe\7"+
		"w\2\2\u00fe\u00ff\7\65\2\2\u00ff\u0100\7\64\2\2\u0100\16\3\2\2\2\u0101"+
		"\u0102\7k\2\2\u0102\u0103\7\65\2\2\u0103\u0104\7\64\2\2\u0104\20\3\2\2"+
		"\2\u0105\u0106\7h\2\2\u0106\u0107\7\65\2\2\u0107\u0108\7\64\2\2\u0108"+
		"\22\3\2\2\2\u0109\u010a\7w\2\2\u010a\u010b\78\2\2\u010b\u010c\7\66\2\2"+
		"\u010c\24\3\2\2\2\u010d\u010e\7k\2\2\u010e\u010f\78\2\2\u010f\u0110\7"+
		"\66\2\2\u0110\26\3\2\2\2\u0111\u0112\7h\2\2\u0112\u0113\78\2\2\u0113\u0114"+
		"\7\66\2\2\u0114\30\3\2\2\2\u0115\u0116\7h\2\2\u0116\u0117\7\63\2\2\u0117"+
		"\u0118\7\64\2\2\u0118\u0119\7:\2\2\u0119\32\3\2\2\2\u011a\u011b\7h\2\2"+
		"\u011b\u011c\7:\2\2\u011c\u011d\7\62\2\2\u011d\34\3\2\2\2\u011e\u011f"+
		"\7d\2\2\u011f\u0120\7q\2\2\u0120\u0121\7q\2\2\u0121\u0122\7n\2\2\u0122"+
		"\u0123\7g\2\2\u0123\u0124\7c\2\2\u0124\u0125\7p\2\2\u0125\36\3\2\2\2\u0126"+
		"\u0127\7d\2\2\u0127\u0128\7:\2\2\u0128 \3\2\2\2\u0129\u012a\7p\2\2\u012a"+
		"\u012b\7w\2\2\u012b\u012c\7o\2\2\u012c\"\3\2\2\2\u012d\u012e\7r\2\2\u012e"+
		"\u012f\7q\2\2\u012f\u0130\7k\2\2\u0130\u0131\7p\2\2\u0131\u0132\7v\2\2"+
		"\u0132\u0133\7g\2\2\u0133\u0134\7t\2\2\u0134$\3\2\2\2\u0135\u0136\7k\2"+
		"\2\u0136\u0137\7p\2\2\u0137\u0138\7v\2\2\u0138&\3\2\2\2\u0139\u013a\7"+
		"p\2\2\u013a\u013b\7w\2\2\u013b\u013c\7n\2\2\u013c\u013d\7n\2\2\u013d("+
		"\3\2\2\2\u013e\u013f\7>\2\2\u013f*\3\2\2\2\u0140\u0141\7@\2\2\u0141,\3"+
		"\2\2\2\u0142\u0143\7?\2\2\u0143\u0144\7?\2\2\u0144.\3\2\2\2\u0145\u0146"+
		"\7@\2\2\u0146\u0147\7?\2\2\u0147\60\3\2\2\2\u0148\u0149\7>\2\2\u0149\u014a"+
		"\7?\2\2\u014a\62\3\2\2\2\u014b\u014c\7#\2\2\u014c\u014d\7?\2\2\u014d\64"+
		"\3\2\2\2\u014e\u014f\7?\2\2\u014f\u0150\7?\2\2\u0150\u0151\7?\2\2\u0151"+
		"\66\3\2\2\2\u0152\u0153\7(\2\2\u0153\u0154\7?\2\2\u01548\3\2\2\2\u0155"+
		"\u0156\7\u0080\2\2\u0156\u0157\7?\2\2\u0157:\3\2\2\2\u0158\u0159\7~\2"+
		"\2\u0159\u015a\7~\2\2\u015a<\3\2\2\2\u015b\u015c\7(\2\2\u015c\u015d\7"+
		"(\2\2\u015d>\3\2\2\2\u015e\u015f\7-\2\2\u015f\u0160\7?\2\2\u0160@\3\2"+
		"\2\2\u0161\u0162\7,\2\2\u0162\u0163\7?\2\2\u0163B\3\2\2\2\u0164\u0165"+
		"\7\61\2\2\u0165\u0166\7?\2\2\u0166D\3\2\2\2\u0167\u0168\7/\2\2\u0168\u0169"+
		"\7?\2\2\u0169F\3\2\2\2\u016a\u016b\7\'\2\2\u016b\u016c\7?\2\2\u016cH\3"+
		"\2\2\2\u016d\u016e\7-\2\2\u016e\u016f\7-\2\2\u016fJ\3\2\2\2\u0170\u0171"+
		"\7/\2\2\u0171\u0172\7/\2\2\u0172L\3\2\2\2\u0173\u0174\7,\2\2\u0174N\3"+
		"\2\2\2\u0175\u0176\7\61\2\2\u0176P\3\2\2\2\u0177\u0178\7\'\2\2\u0178R"+
		"\3\2\2\2\u0179\u017a\7-\2\2\u017aT\3\2\2\2\u017b\u017c\7/\2\2\u017cV\3"+
		"\2\2\2\u017d\u017e\7(\2\2\u017eX\3\2\2\2\u017f\u0180\7~\2\2\u0180Z\3\2"+
		"\2\2\u0181\u0182\7@\2\2\u0182\u0183\7@\2\2\u0183\\\3\2\2\2\u0184\u0185"+
		"\7>\2\2\u0185\u0186\7>\2\2\u0186^\3\2\2\2\u0187\u0188\7}\2\2\u0188`\3"+
		"\2\2\2\u0189\u018a\7\177\2\2\u018ab\3\2\2\2\u018b\u018c\7*\2\2\u018cd"+
		"\3\2\2\2\u018d\u018e\7+\2\2\u018ef\3\2\2\2\u018f\u0190\7]\2\2\u0190h\3"+
		"\2\2\2\u0191\u0192\7_\2\2\u0192j\3\2\2\2\u0193\u0194\7=\2\2\u0194l\3\2"+
		"\2\2\u0195\u0196\7?\2\2\u0196n\3\2\2\2\u0197\u0198\7.\2\2\u0198p\3\2\2"+
		"\2\u0199\u019a\7k\2\2\u019a\u019b\7h\2\2\u019br\3\2\2\2\u019c\u019d\7"+
		"#\2\2\u019dt\3\2\2\2\u019e\u019f\7g\2\2\u019f\u01a0\7n\2\2\u01a0\u01a1"+
		"\7u\2\2\u01a1\u01a2\7g\2\2\u01a2v\3\2\2\2\u01a3\u01a4\7n\2\2\u01a4\u01a5"+
		"\7q\2\2\u01a5\u01a6\7q\2\2\u01a6\u01a7\7r\2\2\u01a7x\3\2\2\2\u01a8\u01a9"+
		"\7r\2\2\u01a9\u01aa\7w\2\2\u01aa\u01ab\7d\2\2\u01ab\u01ac\7n\2\2\u01ac"+
		"\u01ad\7k\2\2\u01ad\u01ae\7e\2\2\u01aez\3\2\2\2\u01af\u01b0\7r\2\2\u01b0"+
		"\u01b1\7t\2\2\u01b1\u01b2\7k\2\2\u01b2\u01b3\7x\2\2\u01b3\u01b4\7c\2\2"+
		"\u01b4\u01b5\7v\2\2\u01b5\u01b6\7g\2\2\u01b6|\3\2\2\2\u01b7\u01b8\7r\2"+
		"\2\u01b8\u01b9\7t\2\2\u01b9\u01ba\7q\2\2\u01ba\u01bb\7v\2\2\u01bb\u01bc"+
		"\7g\2\2\u01bc\u01bd\7e\2\2\u01bd\u01be\7v\2\2\u01be\u01bf\7g\2\2\u01bf"+
		"\u01c0\7f\2\2\u01c0~\3\2\2\2\u01c1\u01c2\7j\2\2\u01c2\u01c3\7k\2\2\u01c3"+
		"\u01c4\7f\2\2\u01c4\u01c5\7f\2\2\u01c5\u01c6\7g\2\2\u01c6\u01c7\7p\2\2"+
		"\u01c7\u0080\3\2\2\2\u01c8\u01c9\7k\2\2\u01c9\u01ca\7o\2\2\u01ca\u01cb"+
		"\7r\2\2\u01cb\u01cc\7q\2\2\u01cc\u01cd\7t\2\2\u01cd\u01ce\7v\2\2\u01ce"+
		"\u01cf\7u\2\2\u01cf\u0082\3\2\2\2\u01d0\u01d1\7k\2\2\u01d1\u01d2\7u\2"+
		"\2\u01d2\u0084\3\2\2\2\u01d3\u01d4\7y\2\2\u01d4\u01d5\7k\2\2\u01d5\u01d6"+
		"\7v\2\2\u01d6\u01d7\7j\2\2\u01d7\u0086\3\2\2\2\u01d8\u01d9\7k\2\2\u01d9"+
		"\u01da\7p\2\2\u01da\u0088\3\2\2\2\u01db\u01dc\7v\2\2\u01dc\u01dd\7t\2"+
		"\2\u01dd\u01de\7{\2\2\u01de\u008a\3\2\2\2\u01df\u01e0\7e\2\2\u01e0\u01e1"+
		"\7c\2\2\u01e1\u01e2\7v\2\2\u01e2\u01e3\7e\2\2\u01e3\u01e4\7j\2\2\u01e4"+
		"\u008c\3\2\2\2\u01e5\u01e6\7h\2\2\u01e6\u01e7\7k\2\2\u01e7\u01e8\7p\2"+
		"\2\u01e8\u01e9\7c\2\2\u01e9\u01ea\7n\2\2\u01ea\u01eb\7n\2\2\u01eb\u01ec"+
		"\7{\2\2\u01ec\u008e\3\2\2\2\u01ed\u01ee\7v\2\2\u01ee\u01ef\7j\2\2\u01ef"+
		"\u01f0\7t\2\2\u01f0\u01f1\7q\2\2\u01f1\u01f2\7y\2\2\u01f2\u01f3\7u\2\2"+
		"\u01f3\u0090\3\2\2\2\u01f4\u01f5\7d\2\2\u01f5\u01f6\7t\2\2\u01f6\u01f7"+
		"\7g\2\2\u01f7\u01f8\7c\2\2\u01f8\u01f9\7m\2\2\u01f9\u0092\3\2\2\2\u01fa"+
		"\u01fb\7e\2\2\u01fb\u01fc\7q\2\2\u01fc\u01fd\7p\2\2\u01fd\u01fe\7v\2\2"+
		"\u01fe\u01ff\7k\2\2\u01ff\u0200\7p\2\2\u0200\u0201\7w\2\2\u0201\u0202"+
		"\7g\2\2\u0202\u0094\3\2\2\2\u0203\u0204\7u\2\2\u0204\u0205\7y\2\2\u0205"+
		"\u0206\7k\2\2\u0206\u0207\7v\2\2\u0207\u0208\7e\2\2\u0208\u0209\7j\2\2"+
		"\u0209\u0096\3\2\2\2\u020a\u020b\7e\2\2\u020b\u020c\7c\2\2\u020c\u020d"+
		"\7u\2\2\u020d\u020e\7g\2\2\u020e\u0098\3\2\2\2\u020f\u0210\7f\2\2\u0210"+
		"\u0211\7g\2\2\u0211\u0212\7h\2\2\u0212\u0213\7c\2\2\u0213\u0214\7w\2\2"+
		"\u0214\u0215\7n\2\2\u0215\u0216\7v\2\2\u0216\u009a\3\2\2\2\u0217\u0218"+
		"\7t\2\2\u0218\u0219\7g\2\2\u0219\u021a\7v\2\2\u021a\u021b\7w\2\2\u021b"+
		"\u021c\7t\2\2\u021c\u021d\7p\2\2\u021d\u009c\3\2\2\2\u021e\u021f\7t\2"+
		"\2\u021f\u0220\7g\2\2\u0220\u0221\7v\2\2\u0221\u0222\7w\2\2\u0222\u0223"+
		"\7t\2\2\u0223\u0224\7p\2\2\u0224\u0225\7\60\2\2\u0225\u0226\7c\2\2\u0226"+
		"\u0227\7f\2\2\u0227\u0228\7f\2\2\u0228\u009e\3\2\2\2\u0229\u022a\7u\2"+
		"\2\u022a\u022b\7v\2\2\u022b\u022c\7c\2\2\u022c\u022d\7v\2\2\u022d\u022e"+
		"\7k\2\2\u022e\u022f\7e\2\2\u022f\u00a0\3\2\2\2\u0230\u0231\7h\2\2\u0231"+
		"\u0232\7k\2\2\u0232\u0233\7p\2\2\u0233\u0234\7c\2\2\u0234\u0235\7n\2\2"+
		"\u0235\u00a2\3\2\2\2\u0236\u0237\7x\2\2\u0237\u0238\7q\2\2\u0238\u0239"+
		"\7k\2\2\u0239\u023a\7f\2\2\u023a\u00a4\3\2\2\2\u023b\u023c\7u\2\2\u023c"+
		"\u023d\7k\2\2\u023d\u023e\7i\2\2\u023e\u023f\7p\2\2\u023f\u0240\7c\2\2"+
		"\u0240\u0241\7v\2\2\u0241\u0242\7w\2\2\u0242\u0243\7t\2\2\u0243\u0244"+
		"\7g\2\2\u0244\u00a6\3\2\2\2\u0245\u0246\7g\2\2\u0246\u0247\7p\2\2\u0247"+
		"\u0248\7w\2\2\u0248\u0249\7o\2\2\u0249\u00a8\3\2\2\2\u024a\u024b\7r\2"+
		"\2\u024b\u024c\7n\2\2\u024c\u024d\7c\2\2\u024d\u024e\7p\2\2\u024e\u00aa"+
		"\3\2\2\2\u024f\u0250\7e\2\2\u0250\u0251\7n\2\2\u0251\u0252\7c\2\2\u0252"+
		"\u0253\7u\2\2\u0253\u0254\7u\2\2\u0254\u00ac\3\2\2\2\u0255\u0256\7r\2"+
		"\2\u0256\u0257\7t\2\2\u0257\u0258\7q\2\2\u0258\u0259\7r\2\2\u0259\u025a"+
		"\7g\2\2\u025a\u025b\7t\2\2\u025b\u025c\7v\2\2\u025c\u025d\7k\2\2\u025d"+
		"\u025e\7g\2\2\u025e\u025f\7u\2\2\u025f\u00ae\3\2\2\2\u0260\u0261\7u\2"+
		"\2\u0261\u0262\7v\2\2\u0262\u0263\7w\2\2\u0263\u0264\7d\2\2\u0264\u00b0"+
		"\3\2\2\2\u0265\u0266\7h\2\2\u0266\u0267\7w\2\2\u0267\u0268\7p\2\2\u0268"+
		"\u0269\7e\2\2\u0269\u026a\7v\2\2\u026a\u026b\7k\2\2\u026b\u026c\7q\2\2"+
		"\u026c\u026d\7p\2\2\u026d\u00b2\3\2\2\2\u026e\u026f\7?\2\2\u026f\u0270"+
		"\7@\2\2\u0270\u00b4\3\2\2\2\u0271\u0272\7v\2\2\u0272\u0273\7t\2\2\u0273"+
		"\u0274\7w\2\2\u0274\u0275\7g\2\2\u0275\u00b6\3\2\2\2\u0276\u0277\7h\2"+
		"\2\u0277\u0278\7c\2\2\u0278\u0279\7n\2\2\u0279\u027a\7u\2\2\u027a\u027b"+
		"\7g\2\2\u027b\u00b8\3\2\2\2\u027c\u027d\7p\2\2\u027d\u027e\7c\2\2\u027e"+
		"\u027f\7o\2\2\u027f\u0280\7g\2\2\u0280\u0281\7u\2\2\u0281\u0282\7r\2\2"+
		"\u0282\u0283\7c\2\2\u0283\u0284\7e\2\2\u0284\u0285\7g\2\2\u0285\u00ba"+
		"\3\2\2\2\u0286\u0287\7i\2\2\u0287\u0288\7n\2\2\u0288\u0289\7q\2\2\u0289"+
		"\u028a\7d\2\2\u028a\u028b\7c\2\2\u028b\u028c\7n\2\2\u028c\u00bc\3\2\2"+
		"\2\u028d\u028e\7k\2\2\u028e\u028f\7p\2\2\u028f\u0290\7n\2\2\u0290\u0291"+
		"\7k\2\2\u0291\u0292\7p\2\2\u0292\u0293\7g\2\2\u0293\u00be\3\2\2\2\u0294"+
		"\u0298\5\u00c5c\2\u0295\u0298\5\u00c1a\2\u0296\u0298\5\u00c9e\2\u0297"+
		"\u0294\3\2\2\2\u0297\u0295\3\2\2\2\u0297\u0296\3\2\2\2\u0298\u0299\3\2"+
		"\2\2\u0299\u029a\7\60\2\2\u029a\u029b\7\60\2\2\u029b\u029f\3\2\2\2\u029c"+
		"\u02a0\5\u00c5c\2\u029d\u02a0\5\u00c1a\2\u029e\u02a0\5\u00c9e\2\u029f"+
		"\u029c\3\2\2\2\u029f\u029d\3\2\2\2\u029f\u029e\3\2\2\2\u02a0\u00c0\3\2"+
		"\2\2\u02a1\u02a5\5\u00dbn\2\u02a2\u02a4\5\u00ddo\2\u02a3\u02a2\3\2\2\2"+
		"\u02a4\u02a7\3\2\2\2\u02a5\u02a3\3\2\2\2\u02a5\u02a6\3\2\2\2\u02a6\u00c2"+
		"\3\2\2\2\u02a7\u02a5\3\2\2\2\u02a8\u02a9\7&\2\2\u02a9\u02aa\t\2\2\2\u02aa"+
		"\u00c4\3\2\2\2\u02ab\u02ad\7/\2\2\u02ac\u02ab\3\2\2\2\u02ac\u02ad\3\2"+
		"\2\2\u02ad\u02ae\3\2\2\2\u02ae\u02b2\t\3\2\2\u02af\u02b1\5\u00dfp\2\u02b0"+
		"\u02af\3\2\2\2\u02b1\u02b4\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2\u02b3\3\2"+
		"\2\2\u02b3\u02ca\3\2\2\2\u02b4\u02b2\3\2\2\2\u02b5\u02ca\7\62\2\2\u02b6"+
		"\u02b7\7\62\2\2\u02b7\u02b8\7z\2\2\u02b8\u02bd\3\2\2\2\u02b9\u02bc\5\u00d5"+
		"k\2\u02ba\u02bc\7a\2\2\u02bb\u02b9\3\2\2\2\u02bb\u02ba\3\2\2\2\u02bc\u02bf"+
		"\3\2\2\2\u02bd\u02bb\3\2\2\2\u02bd\u02be\3\2\2\2\u02be\u02ca\3\2\2\2\u02bf"+
		"\u02bd\3\2\2\2\u02c0\u02c1\7\62\2\2\u02c1\u02c2\7d\2\2\u02c2\u02c6\3\2"+
		"\2\2\u02c3\u02c5\t\4\2\2\u02c4\u02c3\3\2\2\2\u02c5\u02c8\3\2\2\2\u02c6"+
		"\u02c4\3\2\2\2\u02c6\u02c7\3\2\2\2\u02c7\u02ca\3\2\2\2\u02c8\u02c6\3\2"+
		"\2\2\u02c9\u02ac\3\2\2\2\u02c9\u02b5\3\2\2\2\u02c9\u02b6\3\2\2\2\u02c9"+
		"\u02c0\3\2\2\2\u02ca\u00c6\3\2\2\2\u02cb\u02cd\7/\2\2\u02cc\u02cb\3\2"+
		"\2\2\u02cc\u02cd\3\2\2\2\u02cd\u02cf\3\2\2\2\u02ce\u02d0\5\u00dfp\2\u02cf"+
		"\u02ce\3\2\2\2\u02d0\u02d1\3\2\2\2\u02d1\u02cf\3\2\2\2\u02d1\u02d2\3\2"+
		"\2\2\u02d2\u02d3\3\2\2\2\u02d3\u02d7\7\60\2\2\u02d4\u02d6\5\u00dfp\2\u02d5"+
		"\u02d4\3\2\2\2\u02d6\u02d9\3\2\2\2\u02d7\u02d5\3\2\2\2\u02d7\u02d8\3\2"+
		"\2\2\u02d8\u02fc\3\2\2\2\u02d9\u02d7\3\2\2\2\u02da\u02dc\7/\2\2\u02db"+
		"\u02da\3\2\2\2\u02db\u02dc\3\2\2\2\u02dc\u02e0\3\2\2\2\u02dd\u02df\5\u00df"+
		"p\2\u02de\u02dd\3\2\2\2\u02df\u02e2\3\2\2\2\u02e0\u02de\3\2\2\2\u02e0"+
		"\u02e1\3\2\2\2\u02e1\u02e3\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e3\u02e5\7\60"+
		"\2\2\u02e4\u02e6\5\u00dfp\2\u02e5\u02e4\3\2\2\2\u02e6\u02e7\3\2\2\2\u02e7"+
		"\u02e5\3\2\2\2\u02e7\u02e8\3\2\2\2\u02e8\u02fc\3\2\2\2\u02e9\u02eb\7/"+
		"\2\2\u02ea\u02e9\3\2\2\2\u02ea\u02eb\3\2\2\2\u02eb\u02ef\3\2\2\2\u02ec"+
		"\u02ee\5\u00dfp\2\u02ed\u02ec\3\2\2\2\u02ee\u02f1\3\2\2\2\u02ef\u02ed"+
		"\3\2\2\2\u02ef\u02f0\3\2\2\2\u02f0\u02f8\3\2\2\2\u02f1\u02ef\3\2\2\2\u02f2"+
		"\u02f4\7\60\2\2\u02f3\u02f5\5\u00dfp\2\u02f4\u02f3\3\2\2\2\u02f5\u02f6"+
		"\3\2\2\2\u02f6\u02f4\3\2\2\2\u02f6\u02f7\3\2\2\2\u02f7\u02f9\3\2\2\2\u02f8"+
		"\u02f2\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fa\3\2\2\2\u02fa\u02fc\7h"+
		"\2\2\u02fb\u02cc\3\2\2\2\u02fb\u02db\3\2\2\2\u02fb\u02ea\3\2\2\2\u02fc"+
		"\u00c8\3\2\2\2\u02fd\u0301\7$\2\2\u02fe\u0302\5\u00cdg\2\u02ff\u0302\5"+
		"\u00d9m\2\u0300\u0302\t\5\2\2\u0301\u02fe\3\2\2\2\u0301\u02ff\3\2\2\2"+
		"\u0301\u0300\3\2\2\2\u0302\u0303\3\2\2\2\u0303\u0301\3\2\2\2\u0303\u0304"+
		"\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0318\7$\2\2\u0306\u030a\t\5\2\2\u0307"+
		"\u030b\5\u00d1i\2\u0308\u030b\5\u00d9m\2\u0309\u030b\t\6\2\2\u030a\u0307"+
		"\3\2\2\2\u030a\u0308\3\2\2\2\u030a\u0309\3\2\2\2\u030b\u030c\3\2\2\2\u030c"+
		"\u030a\3\2\2\2\u030c\u030d\3\2\2\2\u030d\u030e\3\2\2\2\u030e\u0318\t\5"+
		"\2\2\u030f\u0311\5\u00cfh\2\u0310\u0312\13\2\2\2\u0311\u0310\3\2\2\2\u0312"+
		"\u0313\3\2\2\2\u0313\u0314\3\2\2\2\u0313\u0311\3\2\2\2\u0314\u0315\3\2"+
		"\2\2\u0315\u0316\5\u00cfh\2\u0316\u0318\3\2\2\2\u0317\u02fd\3\2\2\2\u0317"+
		"\u0306\3\2\2\2\u0317\u030f\3\2\2\2\u0318\u00ca\3\2\2\2\u0319\u031c\7b"+
		"\2\2\u031a\u031d\5\u00cdg\2\u031b\u031d\5\u00d7l\2\u031c\u031a\3\2\2\2"+
		"\u031c\u031b\3\2\2\2\u031d\u031e\3\2\2\2\u031e\u031c\3\2\2\2\u031e\u031f"+
		"\3\2\2\2\u031f\u0320\3\2\2\2\u0320\u0321\7b\2\2\u0321\u00cc\3\2\2\2\u0322"+
		"\u0325\7^\2\2\u0323\u0326\t\7\2\2\u0324\u0326\5\u00d3j\2\u0325\u0323\3"+
		"\2\2\2\u0325\u0324\3\2\2\2\u0326\u00ce\3\2\2\2\u0327\u0328\t\5\2\2\u0328"+
		"\u0329\t\5\2\2\u0329\u032a\t\5\2\2\u032a\u00d0\3\2\2\2\u032b\u032e\7^"+
		"\2\2\u032c\u032f\t\b\2\2\u032d\u032f\5\u00d3j\2\u032e\u032c\3\2\2\2\u032e"+
		"\u032d\3\2\2\2\u032f\u00d2\3\2\2\2\u0330\u0331\7w\2\2\u0331\u0332\5\u00d5"+
		"k\2\u0332\u0333\5\u00d5k\2\u0333\u0334\5\u00d5k\2\u0334\u0335\5\u00d5"+
		"k\2\u0335\u00d4\3\2\2\2\u0336\u0337\t\t\2\2\u0337\u00d6\3\2\2\2\u0338"+
		"\u0339\n\n\2\2\u0339\u00d8\3\2\2\2\u033a\u033b\n\13\2\2\u033b\u00da\3"+
		"\2\2\2\u033c\u033d\t\f\2\2\u033d\u00dc\3\2\2\2\u033e\u033f\t\r\2\2\u033f"+
		"\u00de\3\2\2\2\u0340\u0341\t\16\2\2\u0341\u00e0\3\2\2\2\u0342\u0343\6"+
		"q\2\2\u0343\u0347\7%\2\2\u0344\u0346\n\17\2\2\u0345\u0344\3\2\2\2\u0346"+
		"\u0349\3\2\2\2\u0347\u0345\3\2\2\2\u0347\u0348\3\2\2\2\u0348\u034a\3\2"+
		"\2\2\u0349\u0347\3\2\2\2\u034a\u034b\bq\2\2\u034b\u00e2\3\2\2\2\u034c"+
		"\u034d\7\61\2\2\u034d\u034e\7,\2\2\u034e\u034f\7,\2\2\u034f\u0353\3\2"+
		"\2\2\u0350\u0352\13\2\2\2\u0351\u0350\3\2\2\2\u0352\u0355\3\2\2\2\u0353"+
		"\u0354\3\2\2\2\u0353\u0351\3\2\2\2\u0354\u0356\3\2\2\2\u0355\u0353\3\2"+
		"\2\2\u0356\u0357\7,\2\2\u0357\u0358\7\61\2\2\u0358\u0359\3\2\2\2\u0359"+
		"\u035a\br\2\2\u035a\u00e4\3\2\2\2\u035b\u035c\7\61\2\2\u035c\u035d\7,"+
		"\2\2\u035d\u0361\3\2\2\2\u035e\u0360\13\2\2\2\u035f\u035e\3\2\2\2\u0360"+
		"\u0363\3\2\2\2\u0361\u0362\3\2\2\2\u0361\u035f\3\2\2\2\u0362\u0364\3\2"+
		"\2\2\u0363\u0361\3\2\2\2\u0364\u0365\7,\2\2\u0365\u0366\7\61\2\2\u0366"+
		"\u0367\3\2\2\2\u0367\u0368\bs\2\2\u0368\u00e6\3\2\2\2\u0369\u036a\7\61"+
		"\2\2\u036a\u036b\7\61\2\2\u036b\u036f\3\2\2\2\u036c\u036e\n\17\2\2\u036d"+
		"\u036c\3\2\2\2\u036e\u0371\3\2\2\2\u036f\u036d\3\2\2\2\u036f\u0370\3\2"+
		"\2\2\u0370\u0372\3\2\2\2\u0371\u036f\3\2\2\2\u0372\u0373\bt\2\2\u0373"+
		"\u00e8\3\2\2\2\u0374\u0375\t\20\2\2\u0375\u00ea\3\2\2\2\u0376\u0379\t"+
		"\21\2\2\u0377\u0379\5\u00e9u\2\u0378\u0376\3\2\2\2\u0378\u0377\3\2\2\2"+
		"\u0379\u037a\3\2\2\2\u037a\u037b\bv\3\2\u037b\u00ec\3\2\2\2&\2\u0297\u029f"+
		"\u02a5\u02ac\u02b2\u02bb\u02bd\u02c6\u02c9\u02cc\u02d1\u02d7\u02db\u02e0"+
		"\u02e7\u02ea\u02ef\u02f6\u02f8\u02fb\u0301\u0303\u030a\u030c\u0313\u0317"+
		"\u031c\u031e\u0325\u032e\u0347\u0353\u0361\u036f\u0378\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}