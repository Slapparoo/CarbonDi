// Generated from /mnt/c/source/c-workspace/jlow3/ec.java/src/main/antlr4/ec/lang/model/ectypes.g4 by ANTLR 4.7.1
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
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, T__100=101, 
		T__101=102, T__102=103, T__103=104, T__104=105, T__105=106, T__106=107, 
		T__107=108, T__108=109, T__109=110, T__110=111, T__111=112, T__112=113, 
		RANGE=114, ID=115, ANONYMOUS=116, NUM=117, FLOAT=118, STRING=119, BLOCK_COMMENT=120, 
		LINE_COMMENT=121, WS=122, EOL=123;
	public static final int
		RULE_var_type = 0, RULE_builtin_types = 1, RULE_builtin_objects = 2, RULE_builtin_primatives = 3, 
		RULE_builtin_values = 4, RULE_comparator = 5, RULE_assign = 6, RULE_predicate = 7, 
		RULE_operator_mul = 8, RULE_operator_add = 9, RULE_operator_plus = 10, 
		RULE_keyword_ampersand = 11, RULE_operator_bin = 12, RULE_operator_shift = 13, 
		RULE_accessor_type = 14, RULE_keyword_lbrace = 15, RULE_keyword_rbrace = 16, 
		RULE_keyword_lparen = 17, RULE_keyword_rparen = 18, RULE_keyword_lbracket = 19, 
		RULE_keyword_rbracket = 20, RULE_keyword_semi = 21, RULE_keyword_equals = 22, 
		RULE_keyword_comma = 23, RULE_keyword_if = 24, RULE_keyword_else = 25, 
		RULE_keyword_loop = 26, RULE_keyword_public = 27, RULE_keyword_private = 28, 
		RULE_keyword_protected = 29, RULE_keyword_imports = 30, RULE_keyword_is = 31, 
		RULE_keyword_with = 32, RULE_keyword_in = 33, RULE_keyword_try = 34, RULE_keyword_catch = 35, 
		RULE_keyword_finally = 36, RULE_keyword_throw = 37, RULE_keyword_throws = 38, 
		RULE_keyword_asm_x64 = 39, RULE_keyword_break = 40, RULE_keyword_continue = 41, 
		RULE_keyword_switch = 42, RULE_keyword_case = 43, RULE_keyword_default = 44, 
		RULE_keyword_return = 45, RULE_keyword_return_add = 46, RULE_keyword_union = 47, 
		RULE_keyword_static = 48, RULE_keyword_final = 49, RULE_keyword_void = 50, 
		RULE_keyword_object = 51, RULE_keyword_enum = 52, RULE_keyword_plan = 53, 
		RULE_keyword_class = 54, RULE_keyword_properties = 55, RULE_keyword_stub = 56, 
		RULE_keyword_function = 57, RULE_keyword_type = 58, RULE_keyword_array = 59, 
		RULE_keyword_map = 60, RULE_keyword_lambda = 61, RULE_keyword_true = 62, 
		RULE_keyword_false = 63, RULE_keyword_this = 64, RULE_keyword_super = 65, 
		RULE_keyword_extern = 66, RULE_keyword_extern_c = 67, RULE_keyword_namespace = 68, 
		RULE_type_range = 69, RULE_type_id = 70, RULE_type_anonymous = 71, RULE_type_num = 72, 
		RULE_type_float = 73, RULE_type_string = 74, RULE_eol = 75;
	public static final String[] ruleNames = {
		"var_type", "builtin_types", "builtin_objects", "builtin_primatives", 
		"builtin_values", "comparator", "assign", "predicate", "operator_mul", 
		"operator_add", "operator_plus", "keyword_ampersand", "operator_bin", 
		"operator_shift", "accessor_type", "keyword_lbrace", "keyword_rbrace", 
		"keyword_lparen", "keyword_rparen", "keyword_lbracket", "keyword_rbracket", 
		"keyword_semi", "keyword_equals", "keyword_comma", "keyword_if", "keyword_else", 
		"keyword_loop", "keyword_public", "keyword_private", "keyword_protected", 
		"keyword_imports", "keyword_is", "keyword_with", "keyword_in", "keyword_try", 
		"keyword_catch", "keyword_finally", "keyword_throw", "keyword_throws", 
		"keyword_asm_x64", "keyword_break", "keyword_continue", "keyword_switch", 
		"keyword_case", "keyword_default", "keyword_return", "keyword_return_add", 
		"keyword_union", "keyword_static", "keyword_final", "keyword_void", "keyword_object", 
		"keyword_enum", "keyword_plan", "keyword_class", "keyword_properties", 
		"keyword_stub", "keyword_function", "keyword_type", "keyword_array", "keyword_map", 
		"keyword_lambda", "keyword_true", "keyword_false", "keyword_this", "keyword_super", 
		"keyword_extern", "keyword_extern_c", "keyword_namespace", "type_range", 
		"type_id", "type_anonymous", "type_num", "type_float", "type_string", 
		"eol"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'var'", "'@'", "'String'", "'u8'", "'char'", "'i8'", "'u16'", "'i16'", 
		"'u32'", "'i32'", "'f32'", "'u64'", "'i64'", "'f64'", "'f128'", "'f80'", 
		"'boolean'", "'num'", "'num.i'", "'num.u'", "'num.f'", "'num.u8'", "'num.i8'", 
		"'num.u16'", "'num.i16'", "'num.u32'", "'num.i32'", "'num.f32'", "'num.u64'", 
		"'num.i64'", "'num.f64'", "'num.f128'", "'num.f80'", "'null'", "'<'", 
		"'>'", "'=='", "'>='", "'<='", "'!='", "'==='", "'&='", "'~='", "'+='", 
		"'*='", "'/='", "'-='", "'%='", "'++'", "'--'", "'*'", "'/'", "'%'", "'-'", 
		"'+'", "'&'", "'|'", "'>>'", "'<<'", "'{'", "'}'", "'('", "')'", "'['", 
		"']'", "';'", "'='", "','", "'if'", "'else'", "'loop'", "'public'", "'private'", 
		"'protected'", "'imports'", "'is'", "'with'", "'in'", "'try'", "'catch'", 
		"'finally'", "'throw'", "'throws'", "'asm_x64'", "'break'", "'continue'", 
		"'switch'", "'case'", "'default'", "'return'", "'return.add'", "'union'", 
		"'static'", "'final'", "'void'", "'object'", "'enum'", "'plan'", "'class'", 
		"'properties'", "'stub'", "'function'", "'type'", "'array'", "'map'", 
		"'=>'", "'true'", "'false'", "'this'", "'super'", "'extern'", "'extern_c'", 
		"'namespace'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "RANGE", "ID", "ANONYMOUS", "NUM", 
		"FLOAT", "STRING", "BLOCK_COMMENT", "LINE_COMMENT", "WS", "EOL"
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !(_la==T__0 || _la==T__1) ) {
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

	public static class Builtin_typesContext extends ParserRuleContext {
		public Builtin_objectsContext builtin_objects() {
			return getRuleContext(Builtin_objectsContext.class,0);
		}
		public Builtin_primativesContext builtin_primatives() {
			return getRuleContext(Builtin_primativesContext.class,0);
		}
		public Builtin_typesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_types; }
	}

	public final Builtin_typesContext builtin_types() throws RecognitionException {
		Builtin_typesContext _localctx = new Builtin_typesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_builtin_types);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				builtin_objects();
				}
				break;
			case T__3:
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				builtin_primatives();
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

	public static class Builtin_objectsContext extends ParserRuleContext {
		public Builtin_objectsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_objects; }
	}

	public final Builtin_objectsContext builtin_objects() throws RecognitionException {
		Builtin_objectsContext _localctx = new Builtin_objectsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_builtin_objects);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__2);
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
		public Builtin_primativesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtin_primatives; }
	}

	public final Builtin_primativesContext builtin_primatives() throws RecognitionException {
		Builtin_primativesContext _localctx = new Builtin_primativesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_builtin_primatives);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32))) != 0)) ) {
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
		enterRule(_localctx, 8, RULE_builtin_values);
		try {
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__33:
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(T__33);
				}
				break;
			case T__106:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				keyword_true();
				}
				break;
			case T__107:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
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
		enterRule(_localctx, 10, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) ) {
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
		enterRule(_localctx, 12, RULE_assign);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__66:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				keyword_equals();
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(T__43);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(T__44);
				}
				break;
			case T__45:
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				match(T__45);
				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				match(T__46);
				}
				break;
			case T__47:
				enterOuterAlt(_localctx, 6);
				{
				setState(174);
				match(T__47);
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
		enterRule(_localctx, 14, RULE_predicate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !(_la==T__48 || _la==T__49) ) {
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
		enterRule(_localctx, 16, RULE_operator_mul);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__50) | (1L << T__51) | (1L << T__52))) != 0)) ) {
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
		enterRule(_localctx, 18, RULE_operator_add);
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__54:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				operator_plus();
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				match(T__53);
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

	public static class Operator_plusContext extends ParserRuleContext {
		public Operator_plusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_plus; }
	}

	public final Operator_plusContext operator_plus() throws RecognitionException {
		Operator_plusContext _localctx = new Operator_plusContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operator_plus);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
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

	public static class Keyword_ampersandContext extends ParserRuleContext {
		public Keyword_ampersandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_ampersand; }
	}

	public final Keyword_ampersandContext keyword_ampersand() throws RecognitionException {
		Keyword_ampersandContext _localctx = new Keyword_ampersandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_keyword_ampersand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
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
		enterRule(_localctx, 24, RULE_operator_bin);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__55:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				keyword_ampersand();
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(T__56);
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
		enterRule(_localctx, 26, RULE_operator_shift);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_la = _input.LA(1);
			if ( !(_la==T__57 || _la==T__58) ) {
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
		public Accessor_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessor_type; }
	}

	public final Accessor_typeContext accessor_type() throws RecognitionException {
		Accessor_typeContext _localctx = new Accessor_typeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_accessor_type);
		try {
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__71:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				keyword_public();
				}
				break;
			case T__72:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				keyword_private();
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				keyword_protected();
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
		enterRule(_localctx, 30, RULE_keyword_lbrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
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

	public static class Keyword_rbraceContext extends ParserRuleContext {
		public Keyword_rbraceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_rbrace; }
	}

	public final Keyword_rbraceContext keyword_rbrace() throws RecognitionException {
		Keyword_rbraceContext _localctx = new Keyword_rbraceContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_keyword_rbrace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
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

	public static class Keyword_lparenContext extends ParserRuleContext {
		public Keyword_lparenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_lparen; }
	}

	public final Keyword_lparenContext keyword_lparen() throws RecognitionException {
		Keyword_lparenContext _localctx = new Keyword_lparenContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_keyword_lparen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
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

	public static class Keyword_rparenContext extends ParserRuleContext {
		public Keyword_rparenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_rparen; }
	}

	public final Keyword_rparenContext keyword_rparen() throws RecognitionException {
		Keyword_rparenContext _localctx = new Keyword_rparenContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_keyword_rparen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
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

	public static class Keyword_lbracketContext extends ParserRuleContext {
		public Keyword_lbracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_lbracket; }
	}

	public final Keyword_lbracketContext keyword_lbracket() throws RecognitionException {
		Keyword_lbracketContext _localctx = new Keyword_lbracketContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_keyword_lbracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
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

	public static class Keyword_rbracketContext extends ParserRuleContext {
		public Keyword_rbracketContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_rbracket; }
	}

	public final Keyword_rbracketContext keyword_rbracket() throws RecognitionException {
		Keyword_rbracketContext _localctx = new Keyword_rbracketContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_keyword_rbracket);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
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

	public static class Keyword_semiContext extends ParserRuleContext {
		public Keyword_semiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_semi; }
	}

	public final Keyword_semiContext keyword_semi() throws RecognitionException {
		Keyword_semiContext _localctx = new Keyword_semiContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_keyword_semi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
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

	public static class Keyword_equalsContext extends ParserRuleContext {
		public Keyword_equalsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_equals; }
	}

	public final Keyword_equalsContext keyword_equals() throws RecognitionException {
		Keyword_equalsContext _localctx = new Keyword_equalsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_keyword_equals);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
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

	public static class Keyword_commaContext extends ParserRuleContext {
		public Keyword_commaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_comma; }
	}

	public final Keyword_commaContext keyword_comma() throws RecognitionException {
		Keyword_commaContext _localctx = new Keyword_commaContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_keyword_comma);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
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

	public static class Keyword_ifContext extends ParserRuleContext {
		public Keyword_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_if; }
	}

	public final Keyword_ifContext keyword_if() throws RecognitionException {
		Keyword_ifContext _localctx = new Keyword_ifContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_keyword_if);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
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
			setState(220);
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
			setState(222);
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
			setState(224);
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
			setState(226);
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
			setState(228);
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

	public static class Keyword_importsContext extends ParserRuleContext {
		public Keyword_importsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_imports; }
	}

	public final Keyword_importsContext keyword_imports() throws RecognitionException {
		Keyword_importsContext _localctx = new Keyword_importsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_keyword_imports);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
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

	public static class Keyword_isContext extends ParserRuleContext {
		public Keyword_isContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_is; }
	}

	public final Keyword_isContext keyword_is() throws RecognitionException {
		Keyword_isContext _localctx = new Keyword_isContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_keyword_is);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
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

	public static class Keyword_withContext extends ParserRuleContext {
		public Keyword_withContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_with; }
	}

	public final Keyword_withContext keyword_with() throws RecognitionException {
		Keyword_withContext _localctx = new Keyword_withContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_keyword_with);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
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

	public static class Keyword_inContext extends ParserRuleContext {
		public Keyword_inContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_in; }
	}

	public final Keyword_inContext keyword_in() throws RecognitionException {
		Keyword_inContext _localctx = new Keyword_inContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_keyword_in);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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

	public static class Keyword_tryContext extends ParserRuleContext {
		public Keyword_tryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_try; }
	}

	public final Keyword_tryContext keyword_try() throws RecognitionException {
		Keyword_tryContext _localctx = new Keyword_tryContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_keyword_try);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
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

	public static class Keyword_catchContext extends ParserRuleContext {
		public Keyword_catchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_catch; }
	}

	public final Keyword_catchContext keyword_catch() throws RecognitionException {
		Keyword_catchContext _localctx = new Keyword_catchContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_keyword_catch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
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

	public static class Keyword_finallyContext extends ParserRuleContext {
		public Keyword_finallyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_finally; }
	}

	public final Keyword_finallyContext keyword_finally() throws RecognitionException {
		Keyword_finallyContext _localctx = new Keyword_finallyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_keyword_finally);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
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

	public static class Keyword_throwContext extends ParserRuleContext {
		public Keyword_throwContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_throw; }
	}

	public final Keyword_throwContext keyword_throw() throws RecognitionException {
		Keyword_throwContext _localctx = new Keyword_throwContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_keyword_throw);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
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
			setState(246);
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

	public static class Keyword_asm_x64Context extends ParserRuleContext {
		public Keyword_asm_x64Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_asm_x64; }
	}

	public final Keyword_asm_x64Context keyword_asm_x64() throws RecognitionException {
		Keyword_asm_x64Context _localctx = new Keyword_asm_x64Context(_ctx, getState());
		enterRule(_localctx, 78, RULE_keyword_asm_x64);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
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

	public static class Keyword_breakContext extends ParserRuleContext {
		public Keyword_breakContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_break; }
	}

	public final Keyword_breakContext keyword_break() throws RecognitionException {
		Keyword_breakContext _localctx = new Keyword_breakContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_keyword_break);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
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

	public static class Keyword_continueContext extends ParserRuleContext {
		public Keyword_continueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_continue; }
	}

	public final Keyword_continueContext keyword_continue() throws RecognitionException {
		Keyword_continueContext _localctx = new Keyword_continueContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_keyword_continue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
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

	public static class Keyword_switchContext extends ParserRuleContext {
		public Keyword_switchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_switch; }
	}

	public final Keyword_switchContext keyword_switch() throws RecognitionException {
		Keyword_switchContext _localctx = new Keyword_switchContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_keyword_switch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
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

	public static class Keyword_caseContext extends ParserRuleContext {
		public Keyword_caseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_case; }
	}

	public final Keyword_caseContext keyword_case() throws RecognitionException {
		Keyword_caseContext _localctx = new Keyword_caseContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_keyword_case);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
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

	public static class Keyword_defaultContext extends ParserRuleContext {
		public Keyword_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_default; }
	}

	public final Keyword_defaultContext keyword_default() throws RecognitionException {
		Keyword_defaultContext _localctx = new Keyword_defaultContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_keyword_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
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

	public static class Keyword_returnContext extends ParserRuleContext {
		public Keyword_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_return; }
	}

	public final Keyword_returnContext keyword_return() throws RecognitionException {
		Keyword_returnContext _localctx = new Keyword_returnContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_keyword_return);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
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

	public static class Keyword_return_addContext extends ParserRuleContext {
		public Keyword_return_addContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_return_add; }
	}

	public final Keyword_return_addContext keyword_return_add() throws RecognitionException {
		Keyword_return_addContext _localctx = new Keyword_return_addContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_keyword_return_add);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
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

	public static class Keyword_unionContext extends ParserRuleContext {
		public Keyword_unionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_union; }
	}

	public final Keyword_unionContext keyword_union() throws RecognitionException {
		Keyword_unionContext _localctx = new Keyword_unionContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_keyword_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
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

	public static class Keyword_staticContext extends ParserRuleContext {
		public Keyword_staticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_static; }
	}

	public final Keyword_staticContext keyword_static() throws RecognitionException {
		Keyword_staticContext _localctx = new Keyword_staticContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_keyword_static);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
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

	public static class Keyword_finalContext extends ParserRuleContext {
		public Keyword_finalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_final; }
	}

	public final Keyword_finalContext keyword_final() throws RecognitionException {
		Keyword_finalContext _localctx = new Keyword_finalContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_keyword_final);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
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

	public static class Keyword_voidContext extends ParserRuleContext {
		public Keyword_voidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_void; }
	}

	public final Keyword_voidContext keyword_void() throws RecognitionException {
		Keyword_voidContext _localctx = new Keyword_voidContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_keyword_void);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__94);
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

	public static class Keyword_objectContext extends ParserRuleContext {
		public Keyword_objectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_object; }
	}

	public final Keyword_objectContext keyword_object() throws RecognitionException {
		Keyword_objectContext _localctx = new Keyword_objectContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_keyword_object);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(T__95);
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
		enterRule(_localctx, 104, RULE_keyword_enum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(T__96);
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
		enterRule(_localctx, 106, RULE_keyword_plan);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(T__97);
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
		enterRule(_localctx, 108, RULE_keyword_class);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__98);
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
		enterRule(_localctx, 110, RULE_keyword_properties);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__99);
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
		enterRule(_localctx, 112, RULE_keyword_stub);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(T__100);
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
		enterRule(_localctx, 114, RULE_keyword_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__101);
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

	public static class Keyword_typeContext extends ParserRuleContext {
		public Keyword_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_type; }
	}

	public final Keyword_typeContext keyword_type() throws RecognitionException {
		Keyword_typeContext _localctx = new Keyword_typeContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_keyword_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(T__102);
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

	public static class Keyword_arrayContext extends ParserRuleContext {
		public Keyword_arrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_array; }
	}

	public final Keyword_arrayContext keyword_array() throws RecognitionException {
		Keyword_arrayContext _localctx = new Keyword_arrayContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_keyword_array);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(T__103);
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

	public static class Keyword_mapContext extends ParserRuleContext {
		public Keyword_mapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_map; }
	}

	public final Keyword_mapContext keyword_map() throws RecognitionException {
		Keyword_mapContext _localctx = new Keyword_mapContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_keyword_map);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(T__104);
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
		enterRule(_localctx, 122, RULE_keyword_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(T__105);
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
		enterRule(_localctx, 124, RULE_keyword_true);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__106);
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
		enterRule(_localctx, 126, RULE_keyword_false);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(T__107);
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

	public static class Keyword_thisContext extends ParserRuleContext {
		public Keyword_thisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_this; }
	}

	public final Keyword_thisContext keyword_this() throws RecognitionException {
		Keyword_thisContext _localctx = new Keyword_thisContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_keyword_this);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(T__108);
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

	public static class Keyword_superContext extends ParserRuleContext {
		public Keyword_superContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_super; }
	}

	public final Keyword_superContext keyword_super() throws RecognitionException {
		Keyword_superContext _localctx = new Keyword_superContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_keyword_super);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(T__109);
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

	public static class Keyword_externContext extends ParserRuleContext {
		public Keyword_externContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_extern; }
	}

	public final Keyword_externContext keyword_extern() throws RecognitionException {
		Keyword_externContext _localctx = new Keyword_externContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_keyword_extern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(T__110);
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

	public static class Keyword_extern_cContext extends ParserRuleContext {
		public Keyword_extern_cContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_extern_c; }
	}

	public final Keyword_extern_cContext keyword_extern_c() throws RecognitionException {
		Keyword_extern_cContext _localctx = new Keyword_extern_cContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_keyword_extern_c);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(T__111);
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
		enterRule(_localctx, 136, RULE_keyword_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(T__112);
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
		enterRule(_localctx, 138, RULE_type_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
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

	public static class Type_idContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(ectypesParser.ID, 0); }
		public Type_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_id; }
	}

	public final Type_idContext type_id() throws RecognitionException {
		Type_idContext _localctx = new Type_idContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_type_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			((Type_idContext)_localctx).ID = match(ID);
			 /* System.out.println(((Type_idContext)_localctx).ID); */
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
		enterRule(_localctx, 142, RULE_type_anonymous);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
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
		enterRule(_localctx, 144, RULE_type_num);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
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
		enterRule(_localctx, 146, RULE_type_float);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
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
		public Type_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_string; }
	}

	public final Type_stringContext type_string() throws RecognitionException {
		Type_stringContext _localctx = new Type_stringContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_type_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(STRING);
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
		enterRule(_localctx, 150, RULE_eol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3}\u0146\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\3\2\3\2\3\3\3\3\5\3\u009f\n\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\5\6\u00a8\n\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00b2"+
		"\n\b\3\t\3\t\3\n\3\n\3\13\3\13\5\13\u00ba\n\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\5\16\u00c2\n\16\3\17\3\17\3\20\3\20\3\20\5\20\u00c9\n\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3"+
		"*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63"+
		"\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3"+
		"<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3"+
		"H\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3M\2\2N\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv"+
		"xz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\2\b\3\2\3\4\3\2\6#\3\2%-\3\2\63\64\3\2\65\67\3\2<=\2\u0105"+
		"\2\u009a\3\2\2\2\4\u009e\3\2\2\2\6\u00a0\3\2\2\2\b\u00a2\3\2\2\2\n\u00a7"+
		"\3\2\2\2\f\u00a9\3\2\2\2\16\u00b1\3\2\2\2\20\u00b3\3\2\2\2\22\u00b5\3"+
		"\2\2\2\24\u00b9\3\2\2\2\26\u00bb\3\2\2\2\30\u00bd\3\2\2\2\32\u00c1\3\2"+
		"\2\2\34\u00c3\3\2\2\2\36\u00c8\3\2\2\2 \u00ca\3\2\2\2\"\u00cc\3\2\2\2"+
		"$\u00ce\3\2\2\2&\u00d0\3\2\2\2(\u00d2\3\2\2\2*\u00d4\3\2\2\2,\u00d6\3"+
		"\2\2\2.\u00d8\3\2\2\2\60\u00da\3\2\2\2\62\u00dc\3\2\2\2\64\u00de\3\2\2"+
		"\2\66\u00e0\3\2\2\28\u00e2\3\2\2\2:\u00e4\3\2\2\2<\u00e6\3\2\2\2>\u00e8"+
		"\3\2\2\2@\u00ea\3\2\2\2B\u00ec\3\2\2\2D\u00ee\3\2\2\2F\u00f0\3\2\2\2H"+
		"\u00f2\3\2\2\2J\u00f4\3\2\2\2L\u00f6\3\2\2\2N\u00f8\3\2\2\2P\u00fa\3\2"+
		"\2\2R\u00fc\3\2\2\2T\u00fe\3\2\2\2V\u0100\3\2\2\2X\u0102\3\2\2\2Z\u0104"+
		"\3\2\2\2\\\u0106\3\2\2\2^\u0108\3\2\2\2`\u010a\3\2\2\2b\u010c\3\2\2\2"+
		"d\u010e\3\2\2\2f\u0110\3\2\2\2h\u0112\3\2\2\2j\u0114\3\2\2\2l\u0116\3"+
		"\2\2\2n\u0118\3\2\2\2p\u011a\3\2\2\2r\u011c\3\2\2\2t\u011e\3\2\2\2v\u0120"+
		"\3\2\2\2x\u0122\3\2\2\2z\u0124\3\2\2\2|\u0126\3\2\2\2~\u0128\3\2\2\2\u0080"+
		"\u012a\3\2\2\2\u0082\u012c\3\2\2\2\u0084\u012e\3\2\2\2\u0086\u0130\3\2"+
		"\2\2\u0088\u0132\3\2\2\2\u008a\u0134\3\2\2\2\u008c\u0136\3\2\2\2\u008e"+
		"\u0138\3\2\2\2\u0090\u013b\3\2\2\2\u0092\u013d\3\2\2\2\u0094\u013f\3\2"+
		"\2\2\u0096\u0141\3\2\2\2\u0098\u0143\3\2\2\2\u009a\u009b\t\2\2\2\u009b"+
		"\3\3\2\2\2\u009c\u009f\5\6\4\2\u009d\u009f\5\b\5\2\u009e\u009c\3\2\2\2"+
		"\u009e\u009d\3\2\2\2\u009f\5\3\2\2\2\u00a0\u00a1\7\5\2\2\u00a1\7\3\2\2"+
		"\2\u00a2\u00a3\t\3\2\2\u00a3\t\3\2\2\2\u00a4\u00a8\7$\2\2\u00a5\u00a8"+
		"\5~@\2\u00a6\u00a8\5\u0080A\2\u00a7\u00a4\3\2\2\2\u00a7\u00a5\3\2\2\2"+
		"\u00a7\u00a6\3\2\2\2\u00a8\13\3\2\2\2\u00a9\u00aa\t\4\2\2\u00aa\r\3\2"+
		"\2\2\u00ab\u00b2\5.\30\2\u00ac\u00b2\7.\2\2\u00ad\u00b2\7/\2\2\u00ae\u00b2"+
		"\7\60\2\2\u00af\u00b2\7\61\2\2\u00b0\u00b2\7\62\2\2\u00b1\u00ab\3\2\2"+
		"\2\u00b1\u00ac\3\2\2\2\u00b1\u00ad\3\2\2\2\u00b1\u00ae\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\17\3\2\2\2\u00b3\u00b4\t\5\2\2\u00b4"+
		"\21\3\2\2\2\u00b5\u00b6\t\6\2\2\u00b6\23\3\2\2\2\u00b7\u00ba\5\26\f\2"+
		"\u00b8\u00ba\78\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\25\3"+
		"\2\2\2\u00bb\u00bc\79\2\2\u00bc\27\3\2\2\2\u00bd\u00be\7:\2\2\u00be\31"+
		"\3\2\2\2\u00bf\u00c2\5\30\r\2\u00c0\u00c2\7;\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c0\3\2\2\2\u00c2\33\3\2\2\2\u00c3\u00c4\t\7\2\2\u00c4\35\3\2\2\2\u00c5"+
		"\u00c9\58\35\2\u00c6\u00c9\5:\36\2\u00c7\u00c9\5<\37\2\u00c8\u00c5\3\2"+
		"\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\37\3\2\2\2\u00ca\u00cb"+
		"\7>\2\2\u00cb!\3\2\2\2\u00cc\u00cd\7?\2\2\u00cd#\3\2\2\2\u00ce\u00cf\7"+
		"@\2\2\u00cf%\3\2\2\2\u00d0\u00d1\7A\2\2\u00d1\'\3\2\2\2\u00d2\u00d3\7"+
		"B\2\2\u00d3)\3\2\2\2\u00d4\u00d5\7C\2\2\u00d5+\3\2\2\2\u00d6\u00d7\7D"+
		"\2\2\u00d7-\3\2\2\2\u00d8\u00d9\7E\2\2\u00d9/\3\2\2\2\u00da\u00db\7F\2"+
		"\2\u00db\61\3\2\2\2\u00dc\u00dd\7G\2\2\u00dd\63\3\2\2\2\u00de\u00df\7"+
		"H\2\2\u00df\65\3\2\2\2\u00e0\u00e1\7I\2\2\u00e1\67\3\2\2\2\u00e2\u00e3"+
		"\7J\2\2\u00e39\3\2\2\2\u00e4\u00e5\7K\2\2\u00e5;\3\2\2\2\u00e6\u00e7\7"+
		"L\2\2\u00e7=\3\2\2\2\u00e8\u00e9\7M\2\2\u00e9?\3\2\2\2\u00ea\u00eb\7N"+
		"\2\2\u00ebA\3\2\2\2\u00ec\u00ed\7O\2\2\u00edC\3\2\2\2\u00ee\u00ef\7P\2"+
		"\2\u00efE\3\2\2\2\u00f0\u00f1\7Q\2\2\u00f1G\3\2\2\2\u00f2\u00f3\7R\2\2"+
		"\u00f3I\3\2\2\2\u00f4\u00f5\7S\2\2\u00f5K\3\2\2\2\u00f6\u00f7\7T\2\2\u00f7"+
		"M\3\2\2\2\u00f8\u00f9\7U\2\2\u00f9O\3\2\2\2\u00fa\u00fb\7V\2\2\u00fbQ"+
		"\3\2\2\2\u00fc\u00fd\7W\2\2\u00fdS\3\2\2\2\u00fe\u00ff\7X\2\2\u00ffU\3"+
		"\2\2\2\u0100\u0101\7Y\2\2\u0101W\3\2\2\2\u0102\u0103\7Z\2\2\u0103Y\3\2"+
		"\2\2\u0104\u0105\7[\2\2\u0105[\3\2\2\2\u0106\u0107\7\\\2\2\u0107]\3\2"+
		"\2\2\u0108\u0109\7]\2\2\u0109_\3\2\2\2\u010a\u010b\7^\2\2\u010ba\3\2\2"+
		"\2\u010c\u010d\7_\2\2\u010dc\3\2\2\2\u010e\u010f\7`\2\2\u010fe\3\2\2\2"+
		"\u0110\u0111\7a\2\2\u0111g\3\2\2\2\u0112\u0113\7b\2\2\u0113i\3\2\2\2\u0114"+
		"\u0115\7c\2\2\u0115k\3\2\2\2\u0116\u0117\7d\2\2\u0117m\3\2\2\2\u0118\u0119"+
		"\7e\2\2\u0119o\3\2\2\2\u011a\u011b\7f\2\2\u011bq\3\2\2\2\u011c\u011d\7"+
		"g\2\2\u011ds\3\2\2\2\u011e\u011f\7h\2\2\u011fu\3\2\2\2\u0120\u0121\7i"+
		"\2\2\u0121w\3\2\2\2\u0122\u0123\7j\2\2\u0123y\3\2\2\2\u0124\u0125\7k\2"+
		"\2\u0125{\3\2\2\2\u0126\u0127\7l\2\2\u0127}\3\2\2\2\u0128\u0129\7m\2\2"+
		"\u0129\177\3\2\2\2\u012a\u012b\7n\2\2\u012b\u0081\3\2\2\2\u012c\u012d"+
		"\7o\2\2\u012d\u0083\3\2\2\2\u012e\u012f\7p\2\2\u012f\u0085\3\2\2\2\u0130"+
		"\u0131\7q\2\2\u0131\u0087\3\2\2\2\u0132\u0133\7r\2\2\u0133\u0089\3\2\2"+
		"\2\u0134\u0135\7s\2\2\u0135\u008b\3\2\2\2\u0136\u0137\7t\2\2\u0137\u008d"+
		"\3\2\2\2\u0138\u0139\7u\2\2\u0139\u013a\bH\1\2\u013a\u008f\3\2\2\2\u013b"+
		"\u013c\7v\2\2\u013c\u0091\3\2\2\2\u013d\u013e\7w\2\2\u013e\u0093\3\2\2"+
		"\2\u013f\u0140\7x\2\2\u0140\u0095\3\2\2\2\u0141\u0142\7y\2\2\u0142\u0097"+
		"\3\2\2\2\u0143\u0144\7}\2\2\u0144\u0099\3\2\2\2\b\u009e\u00a7\u00b1\u00b9"+
		"\u00c1\u00c8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}