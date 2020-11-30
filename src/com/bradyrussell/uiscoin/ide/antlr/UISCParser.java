package com.bradyrussell.uiscoin.ide.antlr;// Generated from C:/Users/Admin/IdeaProjects/UISCoinCompiler2/src\UISC.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class UISCParser extends Parser {
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
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, CONST=72, ID=73, INT=74, 
		FLOAT=75, STRING=76, CHAR=77, WS=78, SL_COMMENT=79, ML_COMMENT=80;
	public static final int
		RULE_file = 0, RULE_pointer = 1, RULE_varDeclaration = 2, RULE_structDeclaration = 3, 
		RULE_type = 4, RULE_primitiveType = 5, RULE_structType = 6, RULE_booleanLiteral = 7, 
		RULE_arrayInitializer = 8, RULE_functionDeclaration = 9, RULE_formalParameters = 10, 
		RULE_formalParameter = 11, RULE_block = 12, RULE_statement = 13, RULE_elseifStatement = 14, 
		RULE_elseStatement = 15, RULE_tryStatement = 16, RULE_catchStatement = 17, 
		RULE_number = 18, RULE_assembly = 19, RULE_assertion = 20, RULE_exception = 21, 
		RULE_include = 22, RULE_flag = 23, RULE_flagData = 24, RULE_structField = 25, 
		RULE_expression = 26, RULE_exprList = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "pointer", "varDeclaration", "structDeclaration", "type", "primitiveType", 
			"structType", "booleanLiteral", "arrayInitializer", "functionDeclaration", 
			"formalParameters", "formalParameter", "block", "statement", "elseifStatement", 
			"elseStatement", "tryStatement", "catchStatement", "number", "assembly", 
			"assertion", "exception", "include", "flag", "flagData", "structField", 
			"expression", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'='", "';'", "'[]'", "'['", "']'", "'struct'", "'{'", "'}'", 
			"'void'", "'byte'", "'int32'", "'int64'", "'float'", "'true'", "'false'", 
			"'null'", "'('", "')'", "','", "'if'", "'ufori'", "'as'", "'uforeach'", 
			"'while'", "'for'", "'return'", "'+='", "'-='", "'*='", "'/='", "'%='", 
			"'&='", "'|='", "'break'", "'continue'", "'else'", "'try'", "'catch'", 
			"'asm'", "'assert'", "'throw'", "'include'", "'flag'", "'flagdata'", 
			"'.'", "'_'", "'$'", "'#'", "'-'", "'!'", "'--'", "'++'", "'%'", "'*'", 
			"'/'", "'+'", "'&'", "'|'", "'^'", "'~'", "'&&'", "'||'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='", "'?'", "':'", "'const'"
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
			"CONST", "ID", "INT", "FLOAT", "STRING", "CHAR", "WS", "SL_COMMENT", 
			"ML_COMMENT"
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
	public String getGrammarFileName() { return "UISC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UISCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(59);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(56);
					functionDeclaration();
					}
					break;
				case 2:
					{
					setState(57);
					varDeclaration();
					}
					break;
				case 3:
					{
					setState(58);
					statement();
					}
					break;
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__34) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (CONST - 72)) | (1L << (ID - 72)) | (1L << (INT - 72)) | (1L << (FLOAT - 72)) | (1L << (STRING - 72)) | (1L << (CHAR - 72)))) != 0) );
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

	public static class PointerContext extends ParserRuleContext {
		public PointerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterPointer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitPointer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitPointer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerContext pointer() throws RecognitionException {
		PointerContext _localctx = new PointerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pointer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
	 
		public VarDeclarationContext() { }
		public void copyFrom(VarDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarInitializationContext extends VarDeclarationContext {
		public Token constant;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CONST() { return getToken(UISCParser.CONST, 0); }
		public VarInitializationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterVarInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitVarInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitVarInitialization(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAssignmentInitializationContext extends VarDeclarationContext {
		public Token size;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public TerminalNode INT() { return getToken(UISCParser.INT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayAssignmentInitializationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayAssignmentInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayAssignmentInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayAssignmentInitialization(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayStringInitializationContext extends VarDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public ArrayStringInitializationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayStringInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayStringInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayStringInitialization(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayValueInitializationContext extends VarDeclarationContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayValueInitializationContext(VarDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayValueInitialization(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayValueInitialization(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayValueInitialization(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDeclaration);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new VarInitializationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST) {
					{
					setState(65);
					((VarInitializationContext)_localctx).constant = match(CONST);
					}
				}

				setState(68);
				type();
				setState(69);
				match(ID);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(70);
					match(T__1);
					setState(71);
					expression(0);
					}
				}

				setState(74);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new ArrayValueInitializationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				type();
				setState(77);
				match(ID);
				setState(78);
				match(T__3);
				setState(79);
				match(T__1);
				setState(80);
				arrayInitializer();
				setState(81);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new ArrayStringInitializationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				type();
				setState(84);
				match(ID);
				setState(85);
				match(T__3);
				setState(86);
				match(T__1);
				setState(87);
				match(STRING);
				setState(88);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new ArrayAssignmentInitializationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(90);
				type();
				setState(91);
				match(ID);
				setState(92);
				match(T__4);
				setState(93);
				((ArrayAssignmentInitializationContext)_localctx).size = match(INT);
				setState(94);
				match(T__5);
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(95);
					match(T__1);
					setState(96);
					expression(0);
					}
				}

				setState(99);
				match(T__2);
				}
				break;
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

	public static class StructDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public List<VarDeclarationContext> varDeclaration() {
			return getRuleContexts(VarDeclarationContext.class);
		}
		public VarDeclarationContext varDeclaration(int i) {
			return getRuleContext(VarDeclarationContext.class,i);
		}
		public StructDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDeclarationContext structDeclaration() throws RecognitionException {
		StructDeclarationContext _localctx = new StructDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_structDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__6);
			setState(104);
			match(ID);
			setState(105);
			match(T__7);
			setState(107); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(106);
				varDeclaration();
				}
				}
				setState(109); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__9 - 10)) | (1L << (T__10 - 10)) | (1L << (T__11 - 10)) | (1L << (T__12 - 10)) | (1L << (T__13 - 10)) | (1L << (CONST - 10)) | (1L << (ID - 10)))) != 0) );
			setState(111);
			match(T__8);
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

	public static class TypeContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public StructTypeContext structType() {
			return getRuleContext(StructTypeContext.class,0);
		}
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
				{
				setState(113);
				primitiveType();
				}
				break;
			case ID:
				{
				setState(114);
				structType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(117);
				pointer();
				}
				break;
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

	public static class PrimitiveTypeContext extends ParserRuleContext {
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitPrimitiveType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitPrimitiveType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
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

	public static class StructTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public StructTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructTypeContext structType() throws RecognitionException {
		StructTypeContext _localctx = new StructTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(ID);
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

	public static class BooleanLiteralContext extends ParserRuleContext {
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBooleanLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBooleanLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
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

	public static class ArrayInitializerContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayInitializer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__7);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (ID - 73)) | (1L << (INT - 73)) | (1L << (FLOAT - 73)) | (1L << (STRING - 73)) | (1L << (CHAR - 73)))) != 0)) {
				{
				setState(127);
				exprList();
				}
			}

			setState(130);
			match(T__8);
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

	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFunctionDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			type();
			setState(133);
			match(ID);
			setState(134);
			match(T__17);
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (T__9 - 10)) | (1L << (T__10 - 10)) | (1L << (T__11 - 10)) | (1L << (T__12 - 10)) | (1L << (T__13 - 10)) | (1L << (ID - 10)))) != 0)) {
				{
				setState(135);
				formalParameters();
				}
			}

			setState(138);
			match(T__18);
			setState(139);
			block();
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

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			formalParameter();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(142);
				match(T__19);
				setState(143);
				formalParameter();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FormalParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			type();
			setState(150);
			match(ID);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__7);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__34) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (CONST - 72)) | (1L << (ID - 72)) | (1L << (INT - 72)) | (1L << (FLOAT - 72)) | (1L << (STRING - 72)) | (1L << (CHAR - 72)))) != 0)) {
				{
				{
				setState(153);
				statement();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
			match(T__8);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssertionStatementContext extends StatementContext {
		public AssertionContext assertion() {
			return getRuleContext(AssertionContext.class,0);
		}
		public AssertionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssertionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssertionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssertionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FlagStatementContext extends StatementContext {
		public FlagContext flag() {
			return getRuleContext(FlagContext.class,0);
		}
		public FlagStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFlagStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFlagStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFlagStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UforiStatementContext extends StatementContext {
		public Token iterations;
		public Token iterationsEnd;
		public StatementContext forbody;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public List<TerminalNode> INT() { return getTokens(UISCParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(UISCParser.INT, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public UforiStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterUforiStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitUforiStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitUforiStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatementContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UforeachStatementContext extends StatementContext {
		public Token arrayToLoop;
		public StatementContext forbody;
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public UforeachStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterUforeachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitUforeachStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitUforeachStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentStatementContext extends StatementContext {
		public Token lhs;
		public StructFieldContext lhs_struct;
		public ExpressionContext arrayIndex;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public StructFieldContext structField() {
			return getRuleContext(StructFieldContext.class,0);
		}
		public AssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatementContext extends StatementContext {
		public ExpressionContext conditional;
		public StatementContext afterEach;
		public StatementContext forbody;
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ForStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStatementContext extends StatementContext {
		public BreakStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBreakStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBreakStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public ExpressionContext conditional;
		public StatementContext ifbody;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ElseifStatementContext> elseifStatement() {
			return getRuleContexts(ElseifStatementContext.class);
		}
		public ElseifStatementContext elseifStatement(int i) {
			return getRuleContext(ElseifStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatementContext extends StatementContext {
		public ExpressionContext retval;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FlagDataStatementContext extends StatementContext {
		public FlagDataContext flagData() {
			return getRuleContext(FlagDataContext.class,0);
		}
		public FlagDataStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFlagDataStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFlagDataStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFlagDataStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclarationStatementContext extends StatementContext {
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public VarDeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterVarDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitVarDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitVarDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TryCatchStatementContext extends StatementContext {
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public CatchStatementContext catchStatement() {
			return getRuleContext(CatchStatementContext.class,0);
		}
		public TryCatchStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterTryCatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitTryCatchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitTryCatchStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExceptionStatementContext extends StatementContext {
		public ExceptionContext exception() {
			return getRuleContext(ExceptionContext.class,0);
		}
		public ExceptionStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterExceptionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitExceptionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitExceptionStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatementContext extends StatementContext {
		public StatementContext whilebody;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpAndAssignmentStatementContext extends StatementContext {
		public Token lhs;
		public ExpressionContext arrayIndex;
		public Token op;
		public ExpressionContext rhs;
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OpAndAssignmentStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterOpAndAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitOpAndAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitOpAndAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssemblyStatementContext extends StatementContext {
		public AssemblyContext assembly() {
			return getRuleContext(AssemblyContext.class,0);
		}
		public AssemblyStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssemblyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssemblyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssemblyStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncludeStatementContext extends StatementContext {
		public IncludeContext include() {
			return getRuleContext(IncludeContext.class,0);
		}
		public IncludeStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterIncludeStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitIncludeStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitIncludeStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallStatementContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionCallStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFunctionCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFunctionCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFunctionCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructDeclarationStatementContext extends StatementContext {
		public StructDeclarationContext structDeclaration() {
			return getRuleContext(StructDeclarationContext.class,0);
		}
		public StructDeclarationStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructDeclarationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructDeclarationStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStatementContext extends StatementContext {
		public ContinueStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitContinueStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitContinueStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				block();
				}
				break;
			case 2:
				_localctx = new VarDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				varDeclaration();
				}
				break;
			case 3:
				_localctx = new StructDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				structDeclaration();
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(164);
				match(T__20);
				setState(165);
				((IfStatementContext)_localctx).conditional = expression(0);
				setState(166);
				match(T__7);
				setState(168); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(167);
					((IfStatementContext)_localctx).ifbody = statement();
					}
					}
					setState(170); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__34) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (CONST - 72)) | (1L << (ID - 72)) | (1L << (INT - 72)) | (1L << (FLOAT - 72)) | (1L << (STRING - 72)) | (1L << (CHAR - 72)))) != 0) );
				setState(172);
				match(T__8);
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(173);
						elseifStatement();
						}
						} 
					}
					setState(178);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				}
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__36) {
					{
					setState(179);
					elseStatement();
					}
				}

				}
				break;
			case 5:
				_localctx = new UforiStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(182);
				match(T__21);
				setState(183);
				match(T__17);
				setState(184);
				((UforiStatementContext)_localctx).iterations = match(INT);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(185);
					match(T__19);
					setState(186);
					((UforiStatementContext)_localctx).iterationsEnd = match(INT);
					}
				}

				setState(189);
				match(T__22);
				setState(190);
				type();
				setState(191);
				match(ID);
				setState(192);
				match(T__18);
				setState(194); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(193);
						((UforiStatementContext)_localctx).forbody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(196); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 6:
				_localctx = new UforeachStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(198);
				match(T__23);
				setState(199);
				match(T__17);
				setState(200);
				((UforeachStatementContext)_localctx).arrayToLoop = match(ID);
				setState(201);
				match(T__22);
				setState(202);
				varDeclaration();
				setState(203);
				match(T__18);
				setState(205); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(204);
						((UforeachStatementContext)_localctx).forbody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(207); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 7:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(209);
				match(T__24);
				setState(210);
				match(T__17);
				setState(211);
				expression(0);
				setState(212);
				match(T__18);
				setState(214); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(213);
						((WhileStatementContext)_localctx).whilebody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(216); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 8:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(218);
				match(T__25);
				setState(219);
				match(T__17);
				setState(220);
				varDeclaration();
				setState(221);
				((ForStatementContext)_localctx).conditional = expression(0);
				setState(222);
				match(T__2);
				setState(223);
				((ForStatementContext)_localctx).afterEach = statement();
				setState(224);
				match(T__18);
				setState(226); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(225);
						((ForStatementContext)_localctx).forbody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(228); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 9:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(230);
				match(T__26);
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (ID - 73)) | (1L << (INT - 73)) | (1L << (FLOAT - 73)) | (1L << (STRING - 73)) | (1L << (CHAR - 73)))) != 0)) {
					{
					setState(231);
					((ReturnStatementContext)_localctx).retval = expression(0);
					}
				}

				setState(234);
				match(T__2);
				}
				break;
			case 10:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(237);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(235);
					((AssignmentStatementContext)_localctx).lhs = match(ID);
					}
					break;
				case 2:
					{
					setState(236);
					((AssignmentStatementContext)_localctx).lhs_struct = structField();
					}
					break;
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(239);
					match(T__4);
					setState(240);
					((AssignmentStatementContext)_localctx).arrayIndex = expression(0);
					setState(241);
					match(T__5);
					}
				}

				setState(245);
				match(T__1);
				setState(246);
				((AssignmentStatementContext)_localctx).rhs = expression(0);
				setState(247);
				match(T__2);
				}
				break;
			case 11:
				_localctx = new OpAndAssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(249);
				((OpAndAssignmentStatementContext)_localctx).lhs = match(ID);
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(250);
					match(T__4);
					setState(251);
					((OpAndAssignmentStatementContext)_localctx).arrayIndex = expression(0);
					setState(252);
					match(T__5);
					}
				}

				setState(256);
				((OpAndAssignmentStatementContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
					((OpAndAssignmentStatementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(257);
				((OpAndAssignmentStatementContext)_localctx).rhs = expression(0);
				setState(258);
				match(T__2);
				}
				break;
			case 12:
				_localctx = new TryCatchStatementContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(260);
				tryStatement();
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__38) {
					{
					setState(261);
					catchStatement();
					}
				}

				}
				break;
			case 13:
				_localctx = new FunctionCallStatementContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(264);
				expression(0);
				setState(265);
				match(T__2);
				}
				break;
			case 14:
				_localctx = new AssemblyStatementContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(267);
				assembly();
				}
				break;
			case 15:
				_localctx = new AssertionStatementContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(268);
				assertion();
				}
				break;
			case 16:
				_localctx = new ExceptionStatementContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(269);
				exception();
				}
				break;
			case 17:
				_localctx = new IncludeStatementContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(270);
				include();
				}
				break;
			case 18:
				_localctx = new FlagStatementContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(271);
				flag();
				}
				break;
			case 19:
				_localctx = new FlagDataStatementContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(272);
				flagData();
				}
				break;
			case 20:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(273);
				match(T__34);
				setState(274);
				match(T__2);
				}
				break;
			case 21:
				_localctx = new ContinueStatementContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(275);
				match(T__35);
				setState(276);
				match(T__2);
				}
				break;
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

	public static class ElseifStatementContext extends ParserRuleContext {
		public ExpressionContext conditional;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterElseifStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitElseifStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitElseifStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifStatementContext elseifStatement() throws RecognitionException {
		ElseifStatementContext _localctx = new ElseifStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elseifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(T__36);
			setState(280);
			match(T__20);
			setState(281);
			match(T__17);
			setState(282);
			((ElseifStatementContext)_localctx).conditional = expression(0);
			setState(283);
			match(T__18);
			setState(284);
			match(T__7);
			setState(286); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(285);
				statement();
				}
				}
				setState(288); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__34) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (CONST - 72)) | (1L << (ID - 72)) | (1L << (INT - 72)) | (1L << (FLOAT - 72)) | (1L << (STRING - 72)) | (1L << (CHAR - 72)))) != 0) );
			setState(290);
			match(T__8);
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

	public static class ElseStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			match(T__36);
			setState(293);
			match(T__7);
			setState(295); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(294);
				statement();
				}
				}
				setState(297); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__34) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (CONST - 72)) | (1L << (ID - 72)) | (1L << (INT - 72)) | (1L << (FLOAT - 72)) | (1L << (STRING - 72)) | (1L << (CHAR - 72)))) != 0) );
			setState(299);
			match(T__8);
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

	public static class TryStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitTryStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitTryStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_tryStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(T__37);
			setState(302);
			match(T__7);
			setState(304); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(303);
				statement();
				}
				}
				setState(306); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__34) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (CONST - 72)) | (1L << (ID - 72)) | (1L << (INT - 72)) | (1L << (FLOAT - 72)) | (1L << (STRING - 72)) | (1L << (CHAR - 72)))) != 0) );
			setState(308);
			match(T__8);
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

	public static class CatchStatementContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CatchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterCatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitCatchStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitCatchStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchStatementContext catchStatement() throws RecognitionException {
		CatchStatementContext _localctx = new CatchStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_catchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(T__38);
			setState(311);
			match(T__17);
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (ID - 73)) | (1L << (INT - 73)) | (1L << (FLOAT - 73)) | (1L << (STRING - 73)) | (1L << (CHAR - 73)))) != 0)) {
				{
				setState(312);
				exprList();
				}
			}

			setState(315);
			match(T__18);
			setState(316);
			match(T__7);
			setState(318); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(317);
				statement();
				}
				}
				setState(320); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__34) | (1L << T__35) | (1L << T__37) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (CONST - 72)) | (1L << (ID - 72)) | (1L << (INT - 72)) | (1L << (FLOAT - 72)) | (1L << (STRING - 72)) | (1L << (CHAR - 72)))) != 0) );
			setState(322);
			match(T__8);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(UISCParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(UISCParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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

	public static class AssemblyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssembly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssembly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assembly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(T__39);
			setState(327);
			match(T__17);
			setState(328);
			match(STRING);
			setState(329);
			match(T__18);
			setState(330);
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

	public static class AssertionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAssertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAssertion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAssertion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssertionContext assertion() throws RecognitionException {
		AssertionContext _localctx = new AssertionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			match(T__40);
			setState(333);
			match(T__17);
			setState(334);
			expression(0);
			setState(335);
			match(T__18);
			setState(336);
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

	public static class ExceptionContext extends ParserRuleContext {
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public ExceptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exception; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterException(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitException(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitException(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExceptionContext exception() throws RecognitionException {
		ExceptionContext _localctx = new ExceptionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_exception);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(T__41);
			setState(339);
			match(T__17);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (ID - 73)) | (1L << (INT - 73)) | (1L << (FLOAT - 73)) | (1L << (STRING - 73)) | (1L << (CHAR - 73)))) != 0)) {
				{
				setState(340);
				exprList();
				}
			}

			setState(343);
			match(T__18);
			setState(344);
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

	public static class IncludeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public IncludeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_include; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterInclude(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitInclude(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitInclude(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncludeContext include() throws RecognitionException {
		IncludeContext _localctx = new IncludeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(T__42);
			setState(347);
			match(T__17);
			setState(348);
			match(STRING);
			setState(349);
			match(T__18);
			setState(350);
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

	public static class FlagContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(UISCParser.INT, 0); }
		public FlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFlag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFlag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFlag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlagContext flag() throws RecognitionException {
		FlagContext _localctx = new FlagContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_flag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(T__43);
			setState(353);
			match(T__17);
			setState(354);
			match(INT);
			setState(355);
			match(T__18);
			setState(356);
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

	public static class FlagDataContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public FlagDataContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flagData; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFlagData(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFlagData(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFlagData(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FlagDataContext flagData() throws RecognitionException {
		FlagDataContext _localctx = new FlagDataContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_flagData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			match(T__44);
			setState(359);
			match(T__17);
			setState(360);
			match(STRING);
			setState(361);
			match(T__18);
			setState(362);
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

	public static class StructFieldContext extends ParserRuleContext {
		public Token structname;
		public Token fieldname;
		public List<TerminalNode> ID() { return getTokens(UISCParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UISCParser.ID, i);
		}
		public StructFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructFieldContext structField() throws RecognitionException {
		StructFieldContext _localctx = new StructFieldContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_structField);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			((StructFieldContext)_localctx).structname = match(ID);
			setState(367); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(365);
					match(T__45);
					setState(366);
					((StructFieldContext)_localctx).fieldname = match(ID);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(369); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PostfixOpExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PostfixOpExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterPostfixOpExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitPostfixOpExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitPostfixOpExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModuloExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ModuloExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterModuloExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitModuloExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitModuloExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndOrExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndOrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAndOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAndOrExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAndOrExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MultDivExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterMultDivExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitMultDivExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitMultDivExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixOpExpressionContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixOpExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterPrefixOpExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitPrefixOpExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitPrefixOpExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanLiteralExpressionContext extends ExpressionContext {
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
		}
		public BooleanLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBooleanLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBooleanLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBooleanLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ComparisonExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitComparisonExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitComparisonExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterParenExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitParenExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitParenExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberLiteralExpressionContext extends ExpressionContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNumberLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNumberLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNumberLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ValueAtVariableExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ValueAtVariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterValueAtVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitValueAtVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitValueAtVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastExpressionContext extends ExpressionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitCastExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitCastExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NativeCallExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public NativeCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNativeCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNativeCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNativeCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SizeOfExpressionContext extends ExpressionContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SizeOfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterSizeOfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitSizeOfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitSizeOfExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
		public FunctionCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterFunctionCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitFunctionCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitFunctionCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BitwiseExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BitwiseExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterBitwiseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitBitwiseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitBitwiseExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegateExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegateExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterNegateExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitNegateExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitNegateExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddressOfVariableExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public AddressOfVariableExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAddressOfVariableExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAddressOfVariableExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAddressOfVariableExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LengthOfExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LengthOfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterLengthOfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitLengthOfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitLengthOfExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StructFieldReferenceExpressionContext extends ExpressionContext {
		public StructFieldContext structField() {
			return getRuleContext(StructFieldContext.class,0);
		}
		public StructFieldReferenceExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStructFieldReferenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStructFieldReferenceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStructFieldReferenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralExpressionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(UISCParser.STRING, 0); }
		public StringLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterStringLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitStringLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitStringLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAccessExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayAccessExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterArrayAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitArrayAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitArrayAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableReferenceExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public VariableReferenceExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterVariableReferenceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitVariableReferenceExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitVariableReferenceExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddSubExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterAddSubExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitAddSubExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitAddSubExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualityExpressionContext extends ExpressionContext {
		public ExpressionContext lhs;
		public Token op;
		public ExpressionContext rhs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterEqualityExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitEqualityExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitEqualityExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharLiteralExpressionContext extends ExpressionContext {
		public TerminalNode CHAR() { return getToken(UISCParser.CHAR, 0); }
		public CharLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterCharLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitCharLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitCharLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExpressionContext extends ExpressionContext {
		public ExpressionContext condition;
		public ExpressionContext iftrue;
		public ExpressionContext iffalse;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TernaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterTernaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitTernaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitTernaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				_localctx = new CastExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(372);
				match(T__17);
				setState(373);
				type();
				setState(374);
				match(T__18);
				setState(375);
				expression(27);
				}
				break;
			case 2:
				{
				_localctx = new NativeCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(377);
				match(T__46);
				setState(378);
				match(ID);
				setState(379);
				match(T__17);
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (ID - 73)) | (1L << (INT - 73)) | (1L << (FLOAT - 73)) | (1L << (STRING - 73)) | (1L << (CHAR - 73)))) != 0)) {
					{
					setState(380);
					exprList();
					}
				}

				setState(383);
				match(T__18);
				}
				break;
			case 3:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(384);
				match(ID);
				setState(385);
				match(T__17);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52))) != 0) || ((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (ID - 73)) | (1L << (INT - 73)) | (1L << (FLOAT - 73)) | (1L << (STRING - 73)) | (1L << (CHAR - 73)))) != 0)) {
					{
					setState(386);
					exprList();
					}
				}

				setState(389);
				match(T__18);
				}
				break;
			case 4:
				{
				_localctx = new ArrayAccessExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(390);
				match(ID);
				setState(391);
				match(T__4);
				setState(392);
				expression(0);
				setState(393);
				match(T__5);
				}
				break;
			case 5:
				{
				_localctx = new AddressOfVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(395);
				match(T__47);
				setState(396);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new ValueAtVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(397);
				match(T__0);
				setState(398);
				expression(22);
				}
				break;
			case 7:
				{
				_localctx = new LengthOfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(399);
				match(T__48);
				setState(400);
				expression(21);
				}
				break;
			case 8:
				{
				_localctx = new SizeOfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(401);
				match(T__48);
				setState(402);
				type();
				}
				break;
			case 9:
				{
				_localctx = new NegateExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(403);
				match(T__49);
				setState(404);
				expression(19);
				}
				break;
			case 10:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(405);
				match(T__50);
				setState(406);
				expression(18);
				}
				break;
			case 11:
				{
				_localctx = new PrefixOpExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(407);
				((PrefixOpExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__51 || _la==T__52) ) {
					((PrefixOpExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(408);
				expression(17);
				}
				break;
			case 12:
				{
				_localctx = new VariableReferenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(409);
				match(ID);
				}
				break;
			case 13:
				{
				_localctx = new StructFieldReferenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(410);
				structField();
				}
				break;
			case 14:
				{
				_localctx = new NumberLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(411);
				number();
				}
				break;
			case 15:
				{
				_localctx = new BooleanLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(412);
				booleanLiteral();
				}
				break;
			case 16:
				{
				_localctx = new StringLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(413);
				match(STRING);
				}
				break;
			case 17:
				{
				_localctx = new CharLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(414);
				match(CHAR);
				}
				break;
			case 18:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(415);
				match(T__17);
				setState(416);
				expression(0);
				setState(417);
				match(T__18);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(452);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(450);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new ModuloExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ModuloExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(421);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						{
						setState(422);
						match(T__53);
						}
						setState(423);
						((ModuloExpressionContext)_localctx).rhs = expression(16);
						}
						break;
					case 2:
						{
						_localctx = new MultDivExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((MultDivExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(424);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(425);
						((MultDivExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__54 || _la==T__55) ) {
							((MultDivExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(426);
						((MultDivExpressionContext)_localctx).rhs = expression(15);
						}
						break;
					case 3:
						{
						_localctx = new AddSubExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(427);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(428);
						((AddSubExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__49 || _la==T__56) ) {
							((AddSubExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(429);
						((AddSubExpressionContext)_localctx).rhs = expression(14);
						}
						break;
					case 4:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((BitwiseExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(430);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(431);
						((BitwiseExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60))) != 0)) ) {
							((BitwiseExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(432);
						((BitwiseExpressionContext)_localctx).rhs = expression(13);
						}
						break;
					case 5:
						{
						_localctx = new AndOrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AndOrExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(433);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(434);
						((AndOrExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__61 || _la==T__62) ) {
							((AndOrExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(435);
						((AndOrExpressionContext)_localctx).rhs = expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(436);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(437);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)))) != 0)) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(438);
						((ComparisonExpressionContext)_localctx).rhs = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((EqualityExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(439);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(440);
						((EqualityExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__67 || _la==T__68) ) {
							((EqualityExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(441);
						((EqualityExpressionContext)_localctx).rhs = expression(10);
						}
						break;
					case 8:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((TernaryExpressionContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(442);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(443);
						match(T__69);
						setState(444);
						((TernaryExpressionContext)_localctx).iftrue = expression(0);
						setState(445);
						match(T__70);
						setState(446);
						((TernaryExpressionContext)_localctx).iffalse = expression(2);
						}
						break;
					case 9:
						{
						_localctx = new PostfixOpExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(448);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(449);
						((PostfixOpExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__51 || _la==T__52) ) {
							((PostfixOpExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(454);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ExprListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterExprList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitExprList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitExprList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			expression(0);
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(456);
				match(T__19);
				setState(457);
				expression(0);
				}
				}
				setState(462);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 26:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3R\u01d2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\6\2>\n\2\r\2\16\2"+
		"?\3\3\3\3\3\4\5\4E\n\4\3\4\3\4\3\4\3\4\5\4K\n\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4d\n\4\3\4\3\4\5\4h\n\4\3\5\3\5\3\5\3\5\6\5n\n\5\r\5\16\5o\3\5\3\5"+
		"\3\6\3\6\5\6v\n\6\3\6\5\6y\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\5\n\u0083"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\5\13\u008b\n\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\7\f\u0093\n\f\f\f\16\f\u0096\13\f\3\r\3\r\3\r\3\16\3\16\7\16\u009d"+
		"\n\16\f\16\16\16\u00a0\13\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\6\17\u00ab\n\17\r\17\16\17\u00ac\3\17\3\17\7\17\u00b1\n\17\f\17\16"+
		"\17\u00b4\13\17\3\17\5\17\u00b7\n\17\3\17\3\17\3\17\3\17\3\17\5\17\u00be"+
		"\n\17\3\17\3\17\3\17\3\17\3\17\6\17\u00c5\n\17\r\17\16\17\u00c6\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\6\17\u00d0\n\17\r\17\16\17\u00d1\3\17\3\17"+
		"\3\17\3\17\3\17\6\17\u00d9\n\17\r\17\16\17\u00da\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\6\17\u00e5\n\17\r\17\16\17\u00e6\3\17\3\17\5\17\u00eb"+
		"\n\17\3\17\3\17\3\17\5\17\u00f0\n\17\3\17\3\17\3\17\3\17\5\17\u00f6\n"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0101\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\5\17\u0109\n\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0118\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\6\20\u0121\n\20\r\20\16\20\u0122\3\20\3\20\3\21\3\21\3"+
		"\21\6\21\u012a\n\21\r\21\16\21\u012b\3\21\3\21\3\22\3\22\3\22\6\22\u0133"+
		"\n\22\r\22\16\22\u0134\3\22\3\22\3\23\3\23\3\23\5\23\u013c\n\23\3\23\3"+
		"\23\3\23\6\23\u0141\n\23\r\23\16\23\u0142\3\23\3\23\3\24\3\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\5\27"+
		"\u0158\n\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\6\33\u0172"+
		"\n\33\r\33\16\33\u0173\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\5\34\u0180\n\34\3\34\3\34\3\34\3\34\5\34\u0186\n\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u01a6\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\7\34\u01c5\n\34\f\34\16\34\u01c8\13\34\3\35\3\35\3\35"+
		"\7\35\u01cd\n\35\f\35\16\35\u01d0\13\35\3\35\2\3\66\36\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\r\3\2\f\20\3\2\21\23"+
		"\3\2\36$\3\2LM\3\2\66\67\3\29:\4\2\64\64;;\3\2<?\3\2@A\3\2BE\3\2FG\2\u020a"+
		"\2=\3\2\2\2\4A\3\2\2\2\6g\3\2\2\2\bi\3\2\2\2\nu\3\2\2\2\fz\3\2\2\2\16"+
		"|\3\2\2\2\20~\3\2\2\2\22\u0080\3\2\2\2\24\u0086\3\2\2\2\26\u008f\3\2\2"+
		"\2\30\u0097\3\2\2\2\32\u009a\3\2\2\2\34\u0117\3\2\2\2\36\u0119\3\2\2\2"+
		" \u0126\3\2\2\2\"\u012f\3\2\2\2$\u0138\3\2\2\2&\u0146\3\2\2\2(\u0148\3"+
		"\2\2\2*\u014e\3\2\2\2,\u0154\3\2\2\2.\u015c\3\2\2\2\60\u0162\3\2\2\2\62"+
		"\u0168\3\2\2\2\64\u016e\3\2\2\2\66\u01a5\3\2\2\28\u01c9\3\2\2\2:>\5\24"+
		"\13\2;>\5\6\4\2<>\5\34\17\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>?\3\2\2\2?="+
		"\3\2\2\2?@\3\2\2\2@\3\3\2\2\2AB\7\3\2\2B\5\3\2\2\2CE\7J\2\2DC\3\2\2\2"+
		"DE\3\2\2\2EF\3\2\2\2FG\5\n\6\2GJ\7K\2\2HI\7\4\2\2IK\5\66\34\2JH\3\2\2"+
		"\2JK\3\2\2\2KL\3\2\2\2LM\7\5\2\2Mh\3\2\2\2NO\5\n\6\2OP\7K\2\2PQ\7\6\2"+
		"\2QR\7\4\2\2RS\5\22\n\2ST\7\5\2\2Th\3\2\2\2UV\5\n\6\2VW\7K\2\2WX\7\6\2"+
		"\2XY\7\4\2\2YZ\7N\2\2Z[\7\5\2\2[h\3\2\2\2\\]\5\n\6\2]^\7K\2\2^_\7\7\2"+
		"\2_`\7L\2\2`c\7\b\2\2ab\7\4\2\2bd\5\66\34\2ca\3\2\2\2cd\3\2\2\2de\3\2"+
		"\2\2ef\7\5\2\2fh\3\2\2\2gD\3\2\2\2gN\3\2\2\2gU\3\2\2\2g\\\3\2\2\2h\7\3"+
		"\2\2\2ij\7\t\2\2jk\7K\2\2km\7\n\2\2ln\5\6\4\2ml\3\2\2\2no\3\2\2\2om\3"+
		"\2\2\2op\3\2\2\2pq\3\2\2\2qr\7\13\2\2r\t\3\2\2\2sv\5\f\7\2tv\5\16\b\2"+
		"us\3\2\2\2ut\3\2\2\2vx\3\2\2\2wy\5\4\3\2xw\3\2\2\2xy\3\2\2\2y\13\3\2\2"+
		"\2z{\t\2\2\2{\r\3\2\2\2|}\7K\2\2}\17\3\2\2\2~\177\t\3\2\2\177\21\3\2\2"+
		"\2\u0080\u0082\7\n\2\2\u0081\u0083\58\35\2\u0082\u0081\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\13\2\2\u0085\23\3\2\2\2\u0086"+
		"\u0087\5\n\6\2\u0087\u0088\7K\2\2\u0088\u008a\7\24\2\2\u0089\u008b\5\26"+
		"\f\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\7\25\2\2\u008d\u008e\5\32\16\2\u008e\25\3\2\2\2\u008f\u0094\5\30"+
		"\r\2\u0090\u0091\7\26\2\2\u0091\u0093\5\30\r\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\27\3\2\2"+
		"\2\u0096\u0094\3\2\2\2\u0097\u0098\5\n\6\2\u0098\u0099\7K\2\2\u0099\31"+
		"\3\2\2\2\u009a\u009e\7\n\2\2\u009b\u009d\5\34\17\2\u009c\u009b\3\2\2\2"+
		"\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u00a2\7\13\2\2\u00a2\33\3\2\2\2\u00a3"+
		"\u0118\5\32\16\2\u00a4\u0118\5\6\4\2\u00a5\u0118\5\b\5\2\u00a6\u00a7\7"+
		"\27\2\2\u00a7\u00a8\5\66\34\2\u00a8\u00aa\7\n\2\2\u00a9\u00ab\5\34\17"+
		"\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b2\7\13\2\2\u00af\u00b1\5\36\20"+
		"\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3"+
		"\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b7\5 \21\2\u00b6"+
		"\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u0118\3\2\2\2\u00b8\u00b9\7\30"+
		"\2\2\u00b9\u00ba\7\24\2\2\u00ba\u00bd\7L\2\2\u00bb\u00bc\7\26\2\2\u00bc"+
		"\u00be\7L\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\u00c0\7\31\2\2\u00c0\u00c1\5\n\6\2\u00c1\u00c2\7K\2\2\u00c2"+
		"\u00c4\7\25\2\2\u00c3\u00c5\5\34\17\2\u00c4\u00c3\3\2\2\2\u00c5\u00c6"+
		"\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u0118\3\2\2\2\u00c8"+
		"\u00c9\7\32\2\2\u00c9\u00ca\7\24\2\2\u00ca\u00cb\7K\2\2\u00cb\u00cc\7"+
		"\31\2\2\u00cc\u00cd\5\6\4\2\u00cd\u00cf\7\25\2\2\u00ce\u00d0\5\34\17\2"+
		"\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\u0118\3\2\2\2\u00d3\u00d4\7\33\2\2\u00d4\u00d5\7\24\2\2"+
		"\u00d5\u00d6\5\66\34\2\u00d6\u00d8\7\25\2\2\u00d7\u00d9\5\34\17\2\u00d8"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2"+
		"\2\2\u00db\u0118\3\2\2\2\u00dc\u00dd\7\34\2\2\u00dd\u00de\7\24\2\2\u00de"+
		"\u00df\5\6\4\2\u00df\u00e0\5\66\34\2\u00e0\u00e1\7\5\2\2\u00e1\u00e2\5"+
		"\34\17\2\u00e2\u00e4\7\25\2\2\u00e3\u00e5\5\34\17\2\u00e4\u00e3\3\2\2"+
		"\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u0118"+
		"\3\2\2\2\u00e8\u00ea\7\35\2\2\u00e9\u00eb\5\66\34\2\u00ea\u00e9\3\2\2"+
		"\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u0118\7\5\2\2\u00ed\u00f0"+
		"\7K\2\2\u00ee\u00f0\5\64\33\2\u00ef\u00ed\3\2\2\2\u00ef\u00ee\3\2\2\2"+
		"\u00f0\u00f5\3\2\2\2\u00f1\u00f2\7\7\2\2\u00f2\u00f3\5\66\34\2\u00f3\u00f4"+
		"\7\b\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f8\7\4\2\2\u00f8\u00f9\5\66\34\2\u00f9\u00fa\7"+
		"\5\2\2\u00fa\u0118\3\2\2\2\u00fb\u0100\7K\2\2\u00fc\u00fd\7\7\2\2\u00fd"+
		"\u00fe\5\66\34\2\u00fe\u00ff\7\b\2\2\u00ff\u0101\3\2\2\2\u0100\u00fc\3"+
		"\2\2\2\u0100\u0101\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\t\4\2\2\u0103"+
		"\u0104\5\66\34\2\u0104\u0105\7\5\2\2\u0105\u0118\3\2\2\2\u0106\u0108\5"+
		"\"\22\2\u0107\u0109\5$\23\2\u0108\u0107\3\2\2\2\u0108\u0109\3\2\2\2\u0109"+
		"\u0118\3\2\2\2\u010a\u010b\5\66\34\2\u010b\u010c\7\5\2\2\u010c\u0118\3"+
		"\2\2\2\u010d\u0118\5(\25\2\u010e\u0118\5*\26\2\u010f\u0118\5,\27\2\u0110"+
		"\u0118\5.\30\2\u0111\u0118\5\60\31\2\u0112\u0118\5\62\32\2\u0113\u0114"+
		"\7%\2\2\u0114\u0118\7\5\2\2\u0115\u0116\7&\2\2\u0116\u0118\7\5\2\2\u0117"+
		"\u00a3\3\2\2\2\u0117\u00a4\3\2\2\2\u0117\u00a5\3\2\2\2\u0117\u00a6\3\2"+
		"\2\2\u0117\u00b8\3\2\2\2\u0117\u00c8\3\2\2\2\u0117\u00d3\3\2\2\2\u0117"+
		"\u00dc\3\2\2\2\u0117\u00e8\3\2\2\2\u0117\u00ef\3\2\2\2\u0117\u00fb\3\2"+
		"\2\2\u0117\u0106\3\2\2\2\u0117\u010a\3\2\2\2\u0117\u010d\3\2\2\2\u0117"+
		"\u010e\3\2\2\2\u0117\u010f\3\2\2\2\u0117\u0110\3\2\2\2\u0117\u0111\3\2"+
		"\2\2\u0117\u0112\3\2\2\2\u0117\u0113\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"\35\3\2\2\2\u0119\u011a\7\'\2\2\u011a\u011b\7\27\2\2\u011b\u011c\7\24"+
		"\2\2\u011c\u011d\5\66\34\2\u011d\u011e\7\25\2\2\u011e\u0120\7\n\2\2\u011f"+
		"\u0121\5\34\17\2\u0120\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3"+
		"\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\7\13\2\2\u0125"+
		"\37\3\2\2\2\u0126\u0127\7\'\2\2\u0127\u0129\7\n\2\2\u0128\u012a\5\34\17"+
		"\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c"+
		"\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\7\13\2\2\u012e!\3\2\2\2\u012f"+
		"\u0130\7(\2\2\u0130\u0132\7\n\2\2\u0131\u0133\5\34\17\2\u0132\u0131\3"+
		"\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135"+
		"\u0136\3\2\2\2\u0136\u0137\7\13\2\2\u0137#\3\2\2\2\u0138\u0139\7)\2\2"+
		"\u0139\u013b\7\24\2\2\u013a\u013c\58\35\2\u013b\u013a\3\2\2\2\u013b\u013c"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\7\25\2\2\u013e\u0140\7\n\2\2"+
		"\u013f\u0141\5\34\17\2\u0140\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0140"+
		"\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\7\13\2\2"+
		"\u0145%\3\2\2\2\u0146\u0147\t\5\2\2\u0147\'\3\2\2\2\u0148\u0149\7*\2\2"+
		"\u0149\u014a\7\24\2\2\u014a\u014b\7N\2\2\u014b\u014c\7\25\2\2\u014c\u014d"+
		"\7\5\2\2\u014d)\3\2\2\2\u014e\u014f\7+\2\2\u014f\u0150\7\24\2\2\u0150"+
		"\u0151\5\66\34\2\u0151\u0152\7\25\2\2\u0152\u0153\7\5\2\2\u0153+\3\2\2"+
		"\2\u0154\u0155\7,\2\2\u0155\u0157\7\24\2\2\u0156\u0158\58\35\2\u0157\u0156"+
		"\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\7\25\2\2"+
		"\u015a\u015b\7\5\2\2\u015b-\3\2\2\2\u015c\u015d\7-\2\2\u015d\u015e\7\24"+
		"\2\2\u015e\u015f\7N\2\2\u015f\u0160\7\25\2\2\u0160\u0161\7\5\2\2\u0161"+
		"/\3\2\2\2\u0162\u0163\7.\2\2\u0163\u0164\7\24\2\2\u0164\u0165\7L\2\2\u0165"+
		"\u0166\7\25\2\2\u0166\u0167\7\5\2\2\u0167\61\3\2\2\2\u0168\u0169\7/\2"+
		"\2\u0169\u016a\7\24\2\2\u016a\u016b\7N\2\2\u016b\u016c\7\25\2\2\u016c"+
		"\u016d\7\5\2\2\u016d\63\3\2\2\2\u016e\u0171\7K\2\2\u016f\u0170\7\60\2"+
		"\2\u0170\u0172\7K\2\2\u0171\u016f\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0171"+
		"\3\2\2\2\u0173\u0174\3\2\2\2\u0174\65\3\2\2\2\u0175\u0176\b\34\1\2\u0176"+
		"\u0177\7\24\2\2\u0177\u0178\5\n\6\2\u0178\u0179\7\25\2\2\u0179\u017a\5"+
		"\66\34\35\u017a\u01a6\3\2\2\2\u017b\u017c\7\61\2\2\u017c\u017d\7K\2\2"+
		"\u017d\u017f\7\24\2\2\u017e\u0180\58\35\2\u017f\u017e\3\2\2\2\u017f\u0180"+
		"\3\2\2\2\u0180\u0181\3\2\2\2\u0181\u01a6\7\25\2\2\u0182\u0183\7K\2\2\u0183"+
		"\u0185\7\24\2\2\u0184\u0186\58\35\2\u0185\u0184\3\2\2\2\u0185\u0186\3"+
		"\2\2\2\u0186\u0187\3\2\2\2\u0187\u01a6\7\25\2\2\u0188\u0189\7K\2\2\u0189"+
		"\u018a\7\7\2\2\u018a\u018b\5\66\34\2\u018b\u018c\7\b\2\2\u018c\u01a6\3"+
		"\2\2\2\u018d\u018e\7\62\2\2\u018e\u01a6\7K\2\2\u018f\u0190\7\3\2\2\u0190"+
		"\u01a6\5\66\34\30\u0191\u0192\7\63\2\2\u0192\u01a6\5\66\34\27\u0193\u0194"+
		"\7\63\2\2\u0194\u01a6\5\n\6\2\u0195\u0196\7\64\2\2\u0196\u01a6\5\66\34"+
		"\25\u0197\u0198\7\65\2\2\u0198\u01a6\5\66\34\24\u0199\u019a\t\6\2\2\u019a"+
		"\u01a6\5\66\34\23\u019b\u01a6\7K\2\2\u019c\u01a6\5\64\33\2\u019d\u01a6"+
		"\5&\24\2\u019e\u01a6\5\20\t\2\u019f\u01a6\7N\2\2\u01a0\u01a6\7O\2\2\u01a1"+
		"\u01a2\7\24\2\2\u01a2\u01a3\5\66\34\2\u01a3\u01a4\7\25\2\2\u01a4\u01a6"+
		"\3\2\2\2\u01a5\u0175\3\2\2\2\u01a5\u017b\3\2\2\2\u01a5\u0182\3\2\2\2\u01a5"+
		"\u0188\3\2\2\2\u01a5\u018d\3\2\2\2\u01a5\u018f\3\2\2\2\u01a5\u0191\3\2"+
		"\2\2\u01a5\u0193\3\2\2\2\u01a5\u0195\3\2\2\2\u01a5\u0197\3\2\2\2\u01a5"+
		"\u0199\3\2\2\2\u01a5\u019b\3\2\2\2\u01a5\u019c\3\2\2\2\u01a5\u019d\3\2"+
		"\2\2\u01a5\u019e\3\2\2\2\u01a5\u019f\3\2\2\2\u01a5\u01a0\3\2\2\2\u01a5"+
		"\u01a1\3\2\2\2\u01a6\u01c6\3\2\2\2\u01a7\u01a8\f\21\2\2\u01a8\u01a9\7"+
		"8\2\2\u01a9\u01c5\5\66\34\22\u01aa\u01ab\f\20\2\2\u01ab\u01ac\t\7\2\2"+
		"\u01ac\u01c5\5\66\34\21\u01ad\u01ae\f\17\2\2\u01ae\u01af\t\b\2\2\u01af"+
		"\u01c5\5\66\34\20\u01b0\u01b1\f\16\2\2\u01b1\u01b2\t\t\2\2\u01b2\u01c5"+
		"\5\66\34\17\u01b3\u01b4\f\r\2\2\u01b4\u01b5\t\n\2\2\u01b5\u01c5\5\66\34"+
		"\16\u01b6\u01b7\f\f\2\2\u01b7\u01b8\t\13\2\2\u01b8\u01c5\5\66\34\r\u01b9"+
		"\u01ba\f\13\2\2\u01ba\u01bb\t\f\2\2\u01bb\u01c5\5\66\34\f\u01bc\u01bd"+
		"\f\3\2\2\u01bd\u01be\7H\2\2\u01be\u01bf\5\66\34\2\u01bf\u01c0\7I\2\2\u01c0"+
		"\u01c1\5\66\34\4\u01c1\u01c5\3\2\2\2\u01c2\u01c3\f\22\2\2\u01c3\u01c5"+
		"\t\6\2\2\u01c4\u01a7\3\2\2\2\u01c4\u01aa\3\2\2\2\u01c4\u01ad\3\2\2\2\u01c4"+
		"\u01b0\3\2\2\2\u01c4\u01b3\3\2\2\2\u01c4\u01b6\3\2\2\2\u01c4\u01b9\3\2"+
		"\2\2\u01c4\u01bc\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c8\3\2\2\2\u01c6"+
		"\u01c4\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\67\3\2\2\2\u01c8\u01c6\3\2\2"+
		"\2\u01c9\u01ce\5\66\34\2\u01ca\u01cb\7\26\2\2\u01cb\u01cd\5\66\34\2\u01cc"+
		"\u01ca\3\2\2\2\u01cd\u01d0\3\2\2\2\u01ce\u01cc\3\2\2\2\u01ce\u01cf\3\2"+
		"\2\2\u01cf9\3\2\2\2\u01d0\u01ce\3\2\2\2*=?DJcgoux\u0082\u008a\u0094\u009e"+
		"\u00ac\u00b2\u00b6\u00bd\u00c6\u00d1\u00da\u00e6\u00ea\u00ef\u00f5\u0100"+
		"\u0108\u0117\u0122\u012b\u0134\u013b\u0142\u0157\u0173\u017f\u0185\u01a5"+
		"\u01c4\u01c6\u01ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}