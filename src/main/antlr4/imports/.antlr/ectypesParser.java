// Generated from /workspaces/ec-lang/src/main/antlr4/imports/ectypes.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ectypesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

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
		WS=106, EOL=107;
	public static final int
		RULE_var_type = 0, RULE_builtin_primatives = 1, RULE_builtin_values = 2, 
		RULE_comparator = 3, RULE_assign = 4, RULE_predicate = 5, RULE_operator_mul = 6, 
		RULE_operator_add = 7, RULE_operator_plus = 8, RULE_operator_minus = 9, 
		RULE_keyword_ampersand = 10, RULE_operator_bin = 11, RULE_operator_shift = 12, 
		RULE_accessor_type = 13, RULE_keyword_lbrace = 14, RULE_keyword_rbrace = 15, 
		RULE_keyword_lparen = 16, RULE_keyword_rparen = 17, RULE_keyword_lbracket = 18, 
		RULE_keyword_rbracket = 19, RULE_keyword_semi = 20, RULE_keyword_equals = 21, 
		RULE_keyword_comma = 22, RULE_keyword_if = 23, RULE_keyword_not = 24, 
		RULE_keyword_else = 25, RULE_keyword_loop = 26, RULE_keyword_public = 27, 
		RULE_keyword_private = 28, RULE_keyword_protected = 29, RULE_keyword_hidden = 30, 
		RULE_keyword_imports = 31, RULE_keyword_is = 32, RULE_keyword_with = 33, 
		RULE_keyword_in = 34, RULE_keyword_try = 35, RULE_keyword_catch = 36, 
		RULE_keyword_finally = 37, RULE_keyword_throws = 38, RULE_keyword_break = 39, 
		RULE_keyword_continue = 40, RULE_keyword_switch = 41, RULE_keyword_case = 42, 
		RULE_keyword_default = 43, RULE_keyword_return = 44, RULE_keyword_return_add = 45, 
		RULE_keyword_static = 46, RULE_keyword_final = 47, RULE_keyword_void = 48, 
		RULE_keyword_signature = 49, RULE_keyword_enum = 50, RULE_keyword_plan = 51, 
		RULE_keyword_class = 52, RULE_keyword_properties = 53, RULE_keyword_stub = 54, 
		RULE_keyword_function = 55, RULE_keyword_lambda = 56, RULE_keyword_true = 57, 
		RULE_keyword_false = 58, RULE_keyword_namespace = 59, RULE_keyword_global = 60, 
		RULE_keyword_inline = 61, RULE_type_range = 62, RULE_base_ident = 63, 
		RULE_type_anonymous = 64, RULE_type_num = 65, RULE_type_float = 66, RULE_type_string = 67, 
		RULE_eol = 68;
	private static String[] makeRuleNames() {
		return new String[] {
			"var_type", "builtin_primatives", "builtin_values", "comparator", "assign", 
			"predicate", "operator_mul", "operator_add", "operator_plus", "operator_minus", 
			"keyword_ampersand", "operator_bin", "operator_shift", "accessor_type", 
			"keyword_lbrace", "keyword_rbrace", "keyword_lparen", "keyword_rparen", 
			"keyword_lbracket", "keyword_rbracket", "keyword_semi", "keyword_equals", 
			"keyword_comma", "keyword_if", "keyword_not", "keyword_else", "keyword_loop", 
			"keyword_public", "keyword_private", "keyword_protected", "keyword_hidden", 
			"keyword_imports", "keyword_is", "keyword_with", "keyword_in", "keyword_try", 
			"keyword_catch", "keyword_finally", "keyword_throws", "keyword_break", 
			"keyword_continue", "keyword_switch", "keyword_case", "keyword_default", 
			"keyword_return", "keyword_return_add", "keyword_static", "keyword_final", 
			"keyword_void", "keyword_signature", "keyword_enum", "keyword_plan", 
			"keyword_class", "keyword_properties", "keyword_stub", "keyword_function", 
			"keyword_lambda", "keyword_true", "keyword_false", "keyword_namespace", 
			"keyword_global", "keyword_inline", "type_range", "base_ident", "type_anonymous", 
			"type_num", "type_float", "type_string", "eol"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
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
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "RANGE", 
			"ID", "ANONYMOUS", "NUM", "FLOAT", "STRING", "CSTRING", "PRECOMPILER", 
			"DOC_COMMENT", "BLOCK_COMMENT", "LINE_COMMENT", "WS", "EOL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "ectypes.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ectypesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Var_typeContext extends ParserRuleContext {
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_var_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Builtin_primativesContext extends ParserRuleContext {
		public Keyword_functionContext keyword_function() {
			return getRuleContext(Keyword_functionContext.class,0);
		}
		public Builtin_primativesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_primatives; }
	}

	public final Builtin_primativesContext builtin_primatives() throws RecognitionException {
		Builtin_primativesContext _localctx = new Builtin_primativesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_builtin_primatives);
		try {
			setState(158);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(T__4);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
				match(T__6);
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 7);
				{
				setState(146);
				match(T__7);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 8);
				{
				setState(147);
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 9);
				{
				setState(148);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 10);
				{
				setState(149);
				match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 11);
				{
				setState(150);
				match(T__11);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 12);
				{
				setState(151);
				match(T__12);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 13);
				{
				setState(152);
				match(T__13);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 14);
				{
				setState(153);
				match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 15);
				{
				setState(154);
				match(T__15);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 16);
				{
				setState(155);
				match(T__16);
				}
				break;
			case T__87:
				enterOuterAlt(_localctx, 17);
				{
				setState(156);
				keyword_function();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 18);
				{
				setState(157);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Builtin_valuesContext extends ParserRuleContext {
		public Keyword_trueContext keyword_true() {
			return getRuleContext(Keyword_trueContext.class,0);
		}
		public Keyword_falseContext keyword_false() {
			return getRuleContext(Keyword_falseContext.class,0);
		}
		public Builtin_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_values; }
	}

	public final Builtin_valuesContext builtin_values() throws RecognitionException {
		Builtin_valuesContext _localctx = new Builtin_valuesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_builtin_values);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(T__18);
				}
				break;
			case T__89:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				keyword_true();
				}
				break;
			case T__90:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				keyword_false();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparatorContext extends ParserRuleContext {
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public Keyword_equalsContext keyword_equals() {
			return getRuleContext(Keyword_equalsContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assign);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__53:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				keyword_equals();
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(T__30);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 3);
				{
				setState(169);
				match(T__31);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(T__32);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				match(T__33);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 6);
				{
				setState(172);
				match(T__34);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredicateContext extends ParserRuleContext {
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_la = _input.LA(1);
			if ( !(_la==T__35 || _la==T__36) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_mulContext extends ParserRuleContext {
		public Operator_mulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_mul; }
	}

	public final Operator_mulContext operator_mul() throws RecognitionException {
		Operator_mulContext _localctx = new Operator_mulContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operator_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << T__38) | (1L << T__39))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_addContext extends ParserRuleContext {
		public Operator_minusContext operator_minus() {
			return getRuleContext(Operator_minusContext.class,0);
		}
		public Operator_plusContext operator_plus() {
			return getRuleContext(Operator_plusContext.class,0);
		}
		public Operator_addContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_add; }
	}

	public final Operator_addContext operator_add() throws RecognitionException {
		Operator_addContext _localctx = new Operator_addContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operator_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__41:
				{
				setState(179);
				operator_minus();
				}
				break;
			case T__40:
				{
				setState(180);
				operator_plus();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_plusContext extends ParserRuleContext {
		public Operator_plusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_plus; }
	}

	public final Operator_plusContext operator_plus() throws RecognitionException {
		Operator_plusContext _localctx = new Operator_plusContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operator_plus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__40);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_minusContext extends ParserRuleContext {
		public Operator_minusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_minus; }
	}

	public final Operator_minusContext operator_minus() throws RecognitionException {
		Operator_minusContext _localctx = new Operator_minusContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operator_minus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__41);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_ampersandContext extends ParserRuleContext {
		public Keyword_ampersandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_ampersand; }
	}

	public final Keyword_ampersandContext keyword_ampersand() throws RecognitionException {
		Keyword_ampersandContext _localctx = new Keyword_ampersandContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_keyword_ampersand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__42);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_binContext extends ParserRuleContext {
		public Keyword_ampersandContext keyword_ampersand() {
			return getRuleContext(Keyword_ampersandContext.class,0);
		}
		public Operator_binContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_bin; }
	}

	public final Operator_binContext operator_bin() throws RecognitionException {
		Operator_binContext _localctx = new Operator_binContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operator_bin);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__42:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				keyword_ampersand();
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(T__43);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_shiftContext extends ParserRuleContext {
		public Operator_shiftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_shift; }
	}

	public final Operator_shiftContext operator_shift() throws RecognitionException {
		Operator_shiftContext _localctx = new Operator_shiftContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_operator_shift);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_la = _input.LA(1);
			if ( !(_la==T__44 || _la==T__45) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Accessor_typeContext extends ParserRuleContext {
		public Keyword_publicContext keyword_public() {
			return getRuleContext(Keyword_publicContext.class,0);
		}
		public Keyword_privateContext keyword_private() {
			return getRuleContext(Keyword_privateContext.class,0);
		}
		public Keyword_protectedContext keyword_protected() {
			return getRuleContext(Keyword_protectedContext.class,0);
		}
		public Keyword_hiddenContext keyword_hidden() {
			return getRuleContext(Keyword_hiddenContext.class,0);
		}
		public Accessor_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessor_type; }
	}

	public final Accessor_typeContext accessor_type() throws RecognitionException {
		Accessor_typeContext _localctx = new Accessor_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_accessor_type);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__59:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				keyword_public();
				}
				break;
			case T__60:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				keyword_private();
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				keyword_protected();
				}
				break;
			case T__62:
				enterOuterAlt(_localctx, 4);
				{
				setState(198);
				keyword_hidden();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_lbraceContext extends ParserRuleContext {
		public Keyword_lbraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_lbrace; }
	}

	public final Keyword_lbraceContext keyword_lbrace() throws RecognitionException {
		Keyword_lbraceContext _localctx = new Keyword_lbraceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_keyword_lbrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(T__46);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_rbraceContext extends ParserRuleContext {
		public Keyword_rbraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_rbrace; }
	}

	public final Keyword_rbraceContext keyword_rbrace() throws RecognitionException {
		Keyword_rbraceContext _localctx = new Keyword_rbraceContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_keyword_rbrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__47);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_lparenContext extends ParserRuleContext {
		public Keyword_lparenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_lparen; }
	}

	public final Keyword_lparenContext keyword_lparen() throws RecognitionException {
		Keyword_lparenContext _localctx = new Keyword_lparenContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_keyword_lparen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__48);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_rparenContext extends ParserRuleContext {
		public Keyword_rparenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_rparen; }
	}

	public final Keyword_rparenContext keyword_rparen() throws RecognitionException {
		Keyword_rparenContext _localctx = new Keyword_rparenContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_keyword_rparen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__49);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_lbracketContext extends ParserRuleContext {
		public Keyword_lbracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_lbracket; }
	}

	public final Keyword_lbracketContext keyword_lbracket() throws RecognitionException {
		Keyword_lbracketContext _localctx = new Keyword_lbracketContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_keyword_lbracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__50);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_rbracketContext extends ParserRuleContext {
		public Keyword_rbracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_rbracket; }
	}

	public final Keyword_rbracketContext keyword_rbracket() throws RecognitionException {
		Keyword_rbracketContext _localctx = new Keyword_rbracketContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_keyword_rbracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__51);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_semiContext extends ParserRuleContext {
		public Keyword_semiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_semi; }
	}

	public final Keyword_semiContext keyword_semi() throws RecognitionException {
		Keyword_semiContext _localctx = new Keyword_semiContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_keyword_semi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__52);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_equalsContext extends ParserRuleContext {
		public Keyword_equalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_equals; }
	}

	public final Keyword_equalsContext keyword_equals() throws RecognitionException {
		Keyword_equalsContext _localctx = new Keyword_equalsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_keyword_equals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__53);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_commaContext extends ParserRuleContext {
		public Keyword_commaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_comma; }
	}

	public final Keyword_commaContext keyword_comma() throws RecognitionException {
		Keyword_commaContext _localctx = new Keyword_commaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_keyword_comma);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__54);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_ifContext extends ParserRuleContext {
		public Keyword_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_if; }
	}

	public final Keyword_ifContext keyword_if() throws RecognitionException {
		Keyword_ifContext _localctx = new Keyword_ifContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_keyword_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__55);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_notContext extends ParserRuleContext {
		public Keyword_notContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_not; }
	}

	public final Keyword_notContext keyword_not() throws RecognitionException {
		Keyword_notContext _localctx = new Keyword_notContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_keyword_not);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__56);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_elseContext extends ParserRuleContext {
		public Keyword_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_else; }
	}

	public final Keyword_elseContext keyword_else() throws RecognitionException {
		Keyword_elseContext _localctx = new Keyword_elseContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_keyword_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__57);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_loopContext extends ParserRuleContext {
		public Keyword_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_loop; }
	}

	public final Keyword_loopContext keyword_loop() throws RecognitionException {
		Keyword_loopContext _localctx = new Keyword_loopContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_keyword_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__58);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_publicContext extends ParserRuleContext {
		public Keyword_publicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_public; }
	}

	public final Keyword_publicContext keyword_public() throws RecognitionException {
		Keyword_publicContext _localctx = new Keyword_publicContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_keyword_public);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__59);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_privateContext extends ParserRuleContext {
		public Keyword_privateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_private; }
	}

	public final Keyword_privateContext keyword_private() throws RecognitionException {
		Keyword_privateContext _localctx = new Keyword_privateContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_keyword_private);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__60);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_protectedContext extends ParserRuleContext {
		public Keyword_protectedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_protected; }
	}

	public final Keyword_protectedContext keyword_protected() throws RecognitionException {
		Keyword_protectedContext _localctx = new Keyword_protectedContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_keyword_protected);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__61);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_hiddenContext extends ParserRuleContext {
		public Keyword_hiddenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_hidden; }
	}

	public final Keyword_hiddenContext keyword_hidden() throws RecognitionException {
		Keyword_hiddenContext _localctx = new Keyword_hiddenContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_keyword_hidden);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(T__62);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_importsContext extends ParserRuleContext {
		public Keyword_importsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_imports; }
	}

	public final Keyword_importsContext keyword_imports() throws RecognitionException {
		Keyword_importsContext _localctx = new Keyword_importsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_keyword_imports);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__63);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_isContext extends ParserRuleContext {
		public Keyword_isContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_is; }
	}

	public final Keyword_isContext keyword_is() throws RecognitionException {
		Keyword_isContext _localctx = new Keyword_isContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_keyword_is);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__64);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_withContext extends ParserRuleContext {
		public Keyword_withContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_with; }
	}

	public final Keyword_withContext keyword_with() throws RecognitionException {
		Keyword_withContext _localctx = new Keyword_withContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_keyword_with);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__65);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_inContext extends ParserRuleContext {
		public Keyword_inContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_in; }
	}

	public final Keyword_inContext keyword_in() throws RecognitionException {
		Keyword_inContext _localctx = new Keyword_inContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_keyword_in);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(T__66);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_tryContext extends ParserRuleContext {
		public Keyword_tryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_try; }
	}

	public final Keyword_tryContext keyword_try() throws RecognitionException {
		Keyword_tryContext _localctx = new Keyword_tryContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_keyword_try);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(T__67);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_catchContext extends ParserRuleContext {
		public Keyword_catchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_catch; }
	}

	public final Keyword_catchContext keyword_catch() throws RecognitionException {
		Keyword_catchContext _localctx = new Keyword_catchContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_keyword_catch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(T__68);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_finallyContext extends ParserRuleContext {
		public Keyword_finallyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_finally; }
	}

	public final Keyword_finallyContext keyword_finally() throws RecognitionException {
		Keyword_finallyContext _localctx = new Keyword_finallyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_keyword_finally);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__69);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_throwsContext extends ParserRuleContext {
		public Keyword_throwsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_throws; }
	}

	public final Keyword_throwsContext keyword_throws() throws RecognitionException {
		Keyword_throwsContext _localctx = new Keyword_throwsContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_keyword_throws);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(T__70);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_breakContext extends ParserRuleContext {
		public Keyword_breakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_break; }
	}

	public final Keyword_breakContext keyword_break() throws RecognitionException {
		Keyword_breakContext _localctx = new Keyword_breakContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_keyword_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__71);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_continueContext extends ParserRuleContext {
		public Keyword_continueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_continue; }
	}

	public final Keyword_continueContext keyword_continue() throws RecognitionException {
		Keyword_continueContext _localctx = new Keyword_continueContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_keyword_continue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
			match(T__72);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_switchContext extends ParserRuleContext {
		public Keyword_switchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_switch; }
	}

	public final Keyword_switchContext keyword_switch() throws RecognitionException {
		Keyword_switchContext _localctx = new Keyword_switchContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_keyword_switch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__73);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_caseContext extends ParserRuleContext {
		public Keyword_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_case; }
	}

	public final Keyword_caseContext keyword_case() throws RecognitionException {
		Keyword_caseContext _localctx = new Keyword_caseContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_keyword_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			match(T__74);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_defaultContext extends ParserRuleContext {
		public Keyword_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_default; }
	}

	public final Keyword_defaultContext keyword_default() throws RecognitionException {
		Keyword_defaultContext _localctx = new Keyword_defaultContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_keyword_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(T__75);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_returnContext extends ParserRuleContext {
		public Keyword_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_return; }
	}

	public final Keyword_returnContext keyword_return() throws RecognitionException {
		Keyword_returnContext _localctx = new Keyword_returnContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_keyword_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(T__76);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_return_addContext extends ParserRuleContext {
		public Keyword_return_addContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_return_add; }
	}

	public final Keyword_return_addContext keyword_return_add() throws RecognitionException {
		Keyword_return_addContext _localctx = new Keyword_return_addContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_keyword_return_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__77);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_staticContext extends ParserRuleContext {
		public Keyword_staticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_static; }
	}

	public final Keyword_staticContext keyword_static() throws RecognitionException {
		Keyword_staticContext _localctx = new Keyword_staticContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_keyword_static);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__78);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_finalContext extends ParserRuleContext {
		public Keyword_finalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_final; }
	}

	public final Keyword_finalContext keyword_final() throws RecognitionException {
		Keyword_finalContext _localctx = new Keyword_finalContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_keyword_final);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(T__79);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_voidContext extends ParserRuleContext {
		public Keyword_voidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_void; }
	}

	public final Keyword_voidContext keyword_void() throws RecognitionException {
		Keyword_voidContext _localctx = new Keyword_voidContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_keyword_void);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__80);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_signatureContext extends ParserRuleContext {
		public Keyword_signatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_signature; }
	}

	public final Keyword_signatureContext keyword_signature() throws RecognitionException {
		Keyword_signatureContext _localctx = new Keyword_signatureContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_keyword_signature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(T__81);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_enumContext extends ParserRuleContext {
		public Keyword_enumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_enum; }
	}

	public final Keyword_enumContext keyword_enum() throws RecognitionException {
		Keyword_enumContext _localctx = new Keyword_enumContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_keyword_enum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(T__82);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_planContext extends ParserRuleContext {
		public Keyword_planContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_plan; }
	}

	public final Keyword_planContext keyword_plan() throws RecognitionException {
		Keyword_planContext _localctx = new Keyword_planContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_keyword_plan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(T__83);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_classContext extends ParserRuleContext {
		public Keyword_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_class; }
	}

	public final Keyword_classContext keyword_class() throws RecognitionException {
		Keyword_classContext _localctx = new Keyword_classContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_keyword_class);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(T__84);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_propertiesContext extends ParserRuleContext {
		public Keyword_propertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_properties; }
	}

	public final Keyword_propertiesContext keyword_properties() throws RecognitionException {
		Keyword_propertiesContext _localctx = new Keyword_propertiesContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_keyword_properties);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__85);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_stubContext extends ParserRuleContext {
		public Keyword_stubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_stub; }
	}

	public final Keyword_stubContext keyword_stub() throws RecognitionException {
		Keyword_stubContext _localctx = new Keyword_stubContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_keyword_stub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(T__86);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_functionContext extends ParserRuleContext {
		public Keyword_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_function; }
	}

	public final Keyword_functionContext keyword_function() throws RecognitionException {
		Keyword_functionContext _localctx = new Keyword_functionContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_keyword_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(T__87);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_lambdaContext extends ParserRuleContext {
		public Keyword_lambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_lambda; }
	}

	public final Keyword_lambdaContext keyword_lambda() throws RecognitionException {
		Keyword_lambdaContext _localctx = new Keyword_lambdaContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_keyword_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(T__88);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_trueContext extends ParserRuleContext {
		public Keyword_trueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_true; }
	}

	public final Keyword_trueContext keyword_true() throws RecognitionException {
		Keyword_trueContext _localctx = new Keyword_trueContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_keyword_true);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			match(T__89);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_falseContext extends ParserRuleContext {
		public Keyword_falseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_false; }
	}

	public final Keyword_falseContext keyword_false() throws RecognitionException {
		Keyword_falseContext _localctx = new Keyword_falseContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_keyword_false);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(T__90);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_namespaceContext extends ParserRuleContext {
		public Keyword_namespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_namespace; }
	}

	public final Keyword_namespaceContext keyword_namespace() throws RecognitionException {
		Keyword_namespaceContext _localctx = new Keyword_namespaceContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_keyword_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(T__91);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_globalContext extends ParserRuleContext {
		public Keyword_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_global; }
	}

	public final Keyword_globalContext keyword_global() throws RecognitionException {
		Keyword_globalContext _localctx = new Keyword_globalContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_keyword_global);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(T__92);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Keyword_inlineContext extends ParserRuleContext {
		public Keyword_inlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_inline; }
	}

	public final Keyword_inlineContext keyword_inline() throws RecognitionException {
		Keyword_inlineContext _localctx = new Keyword_inlineContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_keyword_inline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			match(T__93);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_rangeContext extends ParserRuleContext {
		public TerminalNode RANGE() { return getToken(ectypesParser.RANGE, 0); }
		public Type_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_range; }
	}

	public final Type_rangeContext type_range() throws RecognitionException {
		Type_rangeContext _localctx = new Type_rangeContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_type_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(RANGE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_identContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ectypesParser.ID, 0); }
		public TerminalNode ANONYMOUS() { return getToken(ectypesParser.ANONYMOUS, 0); }
		public Base_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_ident; }
	}

	public final Base_identContext base_ident() throws RecognitionException {
		Base_identContext _localctx = new Base_identContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_base_ident);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==ANONYMOUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_anonymousContext extends ParserRuleContext {
		public TerminalNode ANONYMOUS() { return getToken(ectypesParser.ANONYMOUS, 0); }
		public Type_anonymousContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_anonymous; }
	}

	public final Type_anonymousContext type_anonymous() throws RecognitionException {
		Type_anonymousContext _localctx = new Type_anonymousContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_type_anonymous);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(ANONYMOUS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_numContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(ectypesParser.NUM, 0); }
		public Type_numContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_num; }
	}

	public final Type_numContext type_num() throws RecognitionException {
		Type_numContext _localctx = new Type_numContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_type_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_floatContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(ectypesParser.FLOAT, 0); }
		public Type_floatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_float; }
	}

	public final Type_floatContext type_float() throws RecognitionException {
		Type_floatContext _localctx = new Type_floatContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_type_float);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_stringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ectypesParser.STRING, 0); }
		public TerminalNode CSTRING() { return getToken(ectypesParser.CSTRING, 0); }
		public Type_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_string; }
	}

	public final Type_stringContext type_string() throws RecognitionException {
		Type_stringContext _localctx = new Type_stringContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_type_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==CSTRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EolContext extends ParserRuleContext {
		public TerminalNode EOL() { return getToken(ectypesParser.EOL, 0); }
		public EolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eol; }
	}

	public final EolContext eol() throws RecognitionException {
		EolContext _localctx = new EolContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_eol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3m\u013a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00a1"+
		"\n\3\3\4\3\4\3\4\5\4\u00a6\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00b0"+
		"\n\6\3\7\3\7\3\b\3\b\3\t\3\t\5\t\u00b8\n\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\5\r\u00c2\n\r\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u00ca\n\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3"+
		"(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3"+
		":\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3"+
		"E\3F\3F\3F\2\2G\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\2\b\3\2\26 \3\2&\'\3\2(*\3\2/\60\3\2bc\3\2fg\2\u0111\2\u008c\3"+
		"\2\2\2\4\u00a0\3\2\2\2\6\u00a5\3\2\2\2\b\u00a7\3\2\2\2\n\u00af\3\2\2\2"+
		"\f\u00b1\3\2\2\2\16\u00b3\3\2\2\2\20\u00b7\3\2\2\2\22\u00b9\3\2\2\2\24"+
		"\u00bb\3\2\2\2\26\u00bd\3\2\2\2\30\u00c1\3\2\2\2\32\u00c3\3\2\2\2\34\u00c9"+
		"\3\2\2\2\36\u00cb\3\2\2\2 \u00cd\3\2\2\2\"\u00cf\3\2\2\2$\u00d1\3\2\2"+
		"\2&\u00d3\3\2\2\2(\u00d5\3\2\2\2*\u00d7\3\2\2\2,\u00d9\3\2\2\2.\u00db"+
		"\3\2\2\2\60\u00dd\3\2\2\2\62\u00df\3\2\2\2\64\u00e1\3\2\2\2\66\u00e3\3"+
		"\2\2\28\u00e5\3\2\2\2:\u00e7\3\2\2\2<\u00e9\3\2\2\2>\u00eb\3\2\2\2@\u00ed"+
		"\3\2\2\2B\u00ef\3\2\2\2D\u00f1\3\2\2\2F\u00f3\3\2\2\2H\u00f5\3\2\2\2J"+
		"\u00f7\3\2\2\2L\u00f9\3\2\2\2N\u00fb\3\2\2\2P\u00fd\3\2\2\2R\u00ff\3\2"+
		"\2\2T\u0101\3\2\2\2V\u0103\3\2\2\2X\u0105\3\2\2\2Z\u0107\3\2\2\2\\\u0109"+
		"\3\2\2\2^\u010b\3\2\2\2`\u010d\3\2\2\2b\u010f\3\2\2\2d\u0111\3\2\2\2f"+
		"\u0113\3\2\2\2h\u0115\3\2\2\2j\u0117\3\2\2\2l\u0119\3\2\2\2n\u011b\3\2"+
		"\2\2p\u011d\3\2\2\2r\u011f\3\2\2\2t\u0121\3\2\2\2v\u0123\3\2\2\2x\u0125"+
		"\3\2\2\2z\u0127\3\2\2\2|\u0129\3\2\2\2~\u012b\3\2\2\2\u0080\u012d\3\2"+
		"\2\2\u0082\u012f\3\2\2\2\u0084\u0131\3\2\2\2\u0086\u0133\3\2\2\2\u0088"+
		"\u0135\3\2\2\2\u008a\u0137\3\2\2\2\u008c\u008d\7\3\2\2\u008d\3\3\2\2\2"+
		"\u008e\u00a1\7\4\2\2\u008f\u00a1\7\5\2\2\u0090\u00a1\7\6\2\2\u0091\u00a1"+
		"\7\7\2\2\u0092\u00a1\7\b\2\2\u0093\u00a1\7\t\2\2\u0094\u00a1\7\n\2\2\u0095"+
		"\u00a1\7\13\2\2\u0096\u00a1\7\f\2\2\u0097\u00a1\7\r\2\2\u0098\u00a1\7"+
		"\16\2\2\u0099\u00a1\7\17\2\2\u009a\u00a1\7\20\2\2\u009b\u00a1\7\21\2\2"+
		"\u009c\u00a1\7\22\2\2\u009d\u00a1\7\23\2\2\u009e\u00a1\5p9\2\u009f\u00a1"+
		"\7\24\2\2\u00a0\u008e\3\2\2\2\u00a0\u008f\3\2\2\2\u00a0\u0090\3\2\2\2"+
		"\u00a0\u0091\3\2\2\2\u00a0\u0092\3\2\2\2\u00a0\u0093\3\2\2\2\u00a0\u0094"+
		"\3\2\2\2\u00a0\u0095\3\2\2\2\u00a0\u0096\3\2\2\2\u00a0\u0097\3\2\2\2\u00a0"+
		"\u0098\3\2\2\2\u00a0\u0099\3\2\2\2\u00a0\u009a\3\2\2\2\u00a0\u009b\3\2"+
		"\2\2\u00a0\u009c\3\2\2\2\u00a0\u009d\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u009f\3\2\2\2\u00a1\5\3\2\2\2\u00a2\u00a6\7\25\2\2\u00a3\u00a6\5t;\2"+
		"\u00a4\u00a6\5v<\2\u00a5\u00a2\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4"+
		"\3\2\2\2\u00a6\7\3\2\2\2\u00a7\u00a8\t\2\2\2\u00a8\t\3\2\2\2\u00a9\u00b0"+
		"\5,\27\2\u00aa\u00b0\7!\2\2\u00ab\u00b0\7\"\2\2\u00ac\u00b0\7#\2\2\u00ad"+
		"\u00b0\7$\2\2\u00ae\u00b0\7%\2\2\u00af\u00a9\3\2\2\2\u00af\u00aa\3\2\2"+
		"\2\u00af\u00ab\3\2\2\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae"+
		"\3\2\2\2\u00b0\13\3\2\2\2\u00b1\u00b2\t\3\2\2\u00b2\r\3\2\2\2\u00b3\u00b4"+
		"\t\4\2\2\u00b4\17\3\2\2\2\u00b5\u00b8\5\24\13\2\u00b6\u00b8\5\22\n\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\21\3\2\2\2\u00b9\u00ba\7+\2\2"+
		"\u00ba\23\3\2\2\2\u00bb\u00bc\7,\2\2\u00bc\25\3\2\2\2\u00bd\u00be\7-\2"+
		"\2\u00be\27\3\2\2\2\u00bf\u00c2\5\26\f\2\u00c0\u00c2\7.\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\31\3\2\2\2\u00c3\u00c4\t\5\2\2\u00c4"+
		"\33\3\2\2\2\u00c5\u00ca\58\35\2\u00c6\u00ca\5:\36\2\u00c7\u00ca\5<\37"+
		"\2\u00c8\u00ca\5> \2\u00c9\u00c5\3\2\2\2\u00c9\u00c6\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca\35\3\2\2\2\u00cb\u00cc\7\61\2\2\u00cc"+
		"\37\3\2\2\2\u00cd\u00ce\7\62\2\2\u00ce!\3\2\2\2\u00cf\u00d0\7\63\2\2\u00d0"+
		"#\3\2\2\2\u00d1\u00d2\7\64\2\2\u00d2%\3\2\2\2\u00d3\u00d4\7\65\2\2\u00d4"+
		"\'\3\2\2\2\u00d5\u00d6\7\66\2\2\u00d6)\3\2\2\2\u00d7\u00d8\7\67\2\2\u00d8"+
		"+\3\2\2\2\u00d9\u00da\78\2\2\u00da-\3\2\2\2\u00db\u00dc\79\2\2\u00dc/"+
		"\3\2\2\2\u00dd\u00de\7:\2\2\u00de\61\3\2\2\2\u00df\u00e0\7;\2\2\u00e0"+
		"\63\3\2\2\2\u00e1\u00e2\7<\2\2\u00e2\65\3\2\2\2\u00e3\u00e4\7=\2\2\u00e4"+
		"\67\3\2\2\2\u00e5\u00e6\7>\2\2\u00e69\3\2\2\2\u00e7\u00e8\7?\2\2\u00e8"+
		";\3\2\2\2\u00e9\u00ea\7@\2\2\u00ea=\3\2\2\2\u00eb\u00ec\7A\2\2\u00ec?"+
		"\3\2\2\2\u00ed\u00ee\7B\2\2\u00eeA\3\2\2\2\u00ef\u00f0\7C\2\2\u00f0C\3"+
		"\2\2\2\u00f1\u00f2\7D\2\2\u00f2E\3\2\2\2\u00f3\u00f4\7E\2\2\u00f4G\3\2"+
		"\2\2\u00f5\u00f6\7F\2\2\u00f6I\3\2\2\2\u00f7\u00f8\7G\2\2\u00f8K\3\2\2"+
		"\2\u00f9\u00fa\7H\2\2\u00faM\3\2\2\2\u00fb\u00fc\7I\2\2\u00fcO\3\2\2\2"+
		"\u00fd\u00fe\7J\2\2\u00feQ\3\2\2\2\u00ff\u0100\7K\2\2\u0100S\3\2\2\2\u0101"+
		"\u0102\7L\2\2\u0102U\3\2\2\2\u0103\u0104\7M\2\2\u0104W\3\2\2\2\u0105\u0106"+
		"\7N\2\2\u0106Y\3\2\2\2\u0107\u0108\7O\2\2\u0108[\3\2\2\2\u0109\u010a\7"+
		"P\2\2\u010a]\3\2\2\2\u010b\u010c\7Q\2\2\u010c_\3\2\2\2\u010d\u010e\7R"+
		"\2\2\u010ea\3\2\2\2\u010f\u0110\7S\2\2\u0110c\3\2\2\2\u0111\u0112\7T\2"+
		"\2\u0112e\3\2\2\2\u0113\u0114\7U\2\2\u0114g\3\2\2\2\u0115\u0116\7V\2\2"+
		"\u0116i\3\2\2\2\u0117\u0118\7W\2\2\u0118k\3\2\2\2\u0119\u011a\7X\2\2\u011a"+
		"m\3\2\2\2\u011b\u011c\7Y\2\2\u011co\3\2\2\2\u011d\u011e\7Z\2\2\u011eq"+
		"\3\2\2\2\u011f\u0120\7[\2\2\u0120s\3\2\2\2\u0121\u0122\7\\\2\2\u0122u"+
		"\3\2\2\2\u0123\u0124\7]\2\2\u0124w\3\2\2\2\u0125\u0126\7^\2\2\u0126y\3"+
		"\2\2\2\u0127\u0128\7_\2\2\u0128{\3\2\2\2\u0129\u012a\7`\2\2\u012a}\3\2"+
		"\2\2\u012b\u012c\7a\2\2\u012c\177\3\2\2\2\u012d\u012e\t\6\2\2\u012e\u0081"+
		"\3\2\2\2\u012f\u0130\7c\2\2\u0130\u0083\3\2\2\2\u0131\u0132\7d\2\2\u0132"+
		"\u0085\3\2\2\2\u0133\u0134\7e\2\2\u0134\u0087\3\2\2\2\u0135\u0136\t\7"+
		"\2\2\u0136\u0089\3\2\2\2\u0137\u0138\7m\2\2\u0138\u008b\3\2\2\2\b\u00a0"+
		"\u00a5\u00af\u00b7\u00c1\u00c9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}