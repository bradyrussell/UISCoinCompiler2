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
		T__59=60, ID=61, INT=62, FLOAT=63, STRING=64, CHAR=65, WS=66, SL_COMMENT=67, 
		ML_COMMENT=68;
	public static final int
		RULE_file = 0, RULE_pointer = 1, RULE_varDeclaration = 2, RULE_type = 3, 
		RULE_booleanLiteral = 4, RULE_arrayInitializer = 5, RULE_functionDeclaration = 6, 
		RULE_formalParameters = 7, RULE_formalParameter = 8, RULE_block = 9, RULE_statement = 10, 
		RULE_elseifStatement = 11, RULE_elseStatement = 12, RULE_tryStatement = 13, 
		RULE_catchStatement = 14, RULE_number = 15, RULE_assembly = 16, RULE_assertion = 17, 
		RULE_exception = 18, RULE_expression = 19, RULE_exprList = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "pointer", "varDeclaration", "type", "booleanLiteral", "arrayInitializer", 
			"functionDeclaration", "formalParameters", "formalParameter", "block", 
			"statement", "elseifStatement", "elseStatement", "tryStatement", "catchStatement", 
			"number", "assembly", "assertion", "exception", "expression", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'const'", "'='", "';'", "'['", "']'", "'[]'", "'void'", 
			"'byte'", "'int32'", "'int64'", "'float'", "'true'", "'false'", "'null'", 
			"'{'", "'}'", "'('", "')'", "','", "'if'", "'fori'", "'as'", "'foreach'", 
			"'return'", "'+='", "'-='", "'*='", "'/='", "'%='", "'&='", "'|='", "'else'", 
			"'try'", "'catch'", "'asm'", "'assert'", "'throw'", "'$'", "'#'", "'-'", 
			"'!'", "'%'", "'*'", "'/'", "'+'", "'&'", "'|'", "'^'", "'~'", "'&&'", 
			"'||'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'?'", "':'"
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
			null, "ID", "INT", "FLOAT", "STRING", "CHAR", "WS", "SL_COMMENT", "ML_COMMENT"
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
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(45);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(42);
					functionDeclaration();
					}
					break;
				case 2:
					{
					setState(43);
					varDeclaration();
					}
					break;
				case 3:
					{
					setState(44);
					statement();
					}
					break;
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << ID) | (1L << INT) | (1L << FLOAT))) != 0) || _la==STRING || _la==CHAR );
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
			setState(49);
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
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
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
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new VarInitializationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(51);
					((VarInitializationContext)_localctx).constant = match(T__1);
					}
				}

				setState(54);
				type();
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(55);
					pointer();
					}
				}

				setState(58);
				match(ID);
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(59);
					match(T__2);
					setState(60);
					expression(0);
					}
				}

				setState(63);
				match(T__3);
				}
				break;
			case 2:
				_localctx = new ArrayAssignmentInitializationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				type();
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(66);
					pointer();
					}
				}

				setState(69);
				match(ID);
				setState(70);
				match(T__4);
				setState(71);
				((ArrayAssignmentInitializationContext)_localctx).size = match(INT);
				setState(72);
				match(T__5);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(73);
					match(T__2);
					setState(74);
					expression(0);
					}
				}

				setState(77);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new ArrayValueInitializationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(79);
				type();
				setState(80);
				match(ID);
				setState(81);
				match(T__6);
				setState(82);
				match(T__2);
				setState(83);
				arrayInitializer();
				setState(84);
				match(T__3);
				}
				break;
			case 4:
				_localctx = new ArrayStringInitializationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(86);
				type();
				setState(87);
				match(ID);
				setState(88);
				match(T__6);
				setState(89);
				match(T__2);
				setState(90);
				match(STRING);
				setState(91);
				match(T__3);
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

	public static class TypeContext extends ParserRuleContext {
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
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) ) {
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
		enterRule(_localctx, 8, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
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
		enterRule(_localctx, 10, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__15);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << ID) | (1L << INT) | (1L << FLOAT))) != 0) || _la==STRING || _la==CHAR) {
				{
				setState(100);
				exprList();
				}
			}

			setState(103);
			match(T__16);
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
		enterRule(_localctx, 12, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			type();
			setState(106);
			match(ID);
			setState(107);
			match(T__17);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
				{
				setState(108);
				formalParameters();
				}
			}

			setState(111);
			match(T__18);
			setState(112);
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
		enterRule(_localctx, 14, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			formalParameter();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(115);
				match(T__19);
				setState(116);
				formalParameter();
				}
				}
				setState(121);
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
		public PointerContext pointer() {
			return getRuleContext(PointerContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			type();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(123);
				pointer();
				}
			}

			setState(126);
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
		enterRule(_localctx, 18, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__15);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__20) | (1L << T__21) | (1L << T__23) | (1L << T__24) | (1L << T__33) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << ID) | (1L << INT) | (1L << FLOAT))) != 0) || _la==STRING || _la==CHAR) {
				{
				{
				setState(129);
				statement();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(T__16);
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
	public static class AssignmentStatementContext extends StatementContext {
		public Token lhs;
		public ExpressionContext arrayIndex;
		public ExpressionContext rhs;
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
	public static class IfStatementContext extends StatementContext {
		public ExpressionContext conditional;
		public StatementContext ifbody;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
	public static class ForeachStatementContext extends StatementContext {
		public Token arrayToLoop;
		public StatementContext forbody;
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForeachStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterForeachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitForeachStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitForeachStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForiStatementContext extends StatementContext {
		public Token iterations;
		public StatementContext forbody;
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(UISCParser.ID, 0); }
		public TerminalNode INT() { return getToken(UISCParser.INT, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForiStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).enterForiStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UISCListener ) ((UISCListener)listener).exitForiStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UISCVisitor ) return ((UISCVisitor<? extends T>)visitor).visitForiStatement(this);
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				block();
				}
				break;
			case 2:
				_localctx = new VarDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				varDeclaration();
				}
				break;
			case 3:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(139);
				match(T__20);
				setState(140);
				((IfStatementContext)_localctx).conditional = expression(0);
				setState(141);
				match(T__15);
				setState(142);
				((IfStatementContext)_localctx).ifbody = statement();
				setState(143);
				match(T__16);
				setState(147);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(144);
						elseifStatement();
						}
						} 
					}
					setState(149);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__32) {
					{
					setState(150);
					elseStatement();
					}
				}

				}
				break;
			case 4:
				_localctx = new ForiStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				match(T__21);
				setState(154);
				match(T__17);
				setState(155);
				((ForiStatementContext)_localctx).iterations = match(INT);
				setState(156);
				match(T__22);
				setState(157);
				type();
				setState(158);
				match(ID);
				setState(159);
				match(T__18);
				setState(160);
				((ForiStatementContext)_localctx).forbody = statement();
				}
				break;
			case 5:
				_localctx = new ForeachStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(162);
				match(T__23);
				setState(163);
				match(T__17);
				setState(164);
				((ForeachStatementContext)_localctx).arrayToLoop = match(ID);
				setState(165);
				match(T__22);
				setState(166);
				varDeclaration();
				setState(167);
				match(T__18);
				setState(168);
				((ForeachStatementContext)_localctx).forbody = statement();
				}
				break;
			case 6:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				match(T__24);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << ID) | (1L << INT) | (1L << FLOAT))) != 0) || _la==STRING || _la==CHAR) {
					{
					setState(171);
					((ReturnStatementContext)_localctx).retval = expression(0);
					}
				}

				setState(174);
				match(T__3);
				}
				break;
			case 7:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(175);
				((AssignmentStatementContext)_localctx).lhs = match(ID);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(176);
					match(T__4);
					setState(177);
					((AssignmentStatementContext)_localctx).arrayIndex = expression(0);
					setState(178);
					match(T__5);
					}
				}

				setState(182);
				match(T__2);
				setState(183);
				((AssignmentStatementContext)_localctx).rhs = expression(0);
				setState(184);
				match(T__3);
				}
				break;
			case 8:
				_localctx = new OpAndAssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(186);
				((OpAndAssignmentStatementContext)_localctx).lhs = match(ID);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(187);
					match(T__4);
					setState(188);
					((OpAndAssignmentStatementContext)_localctx).arrayIndex = expression(0);
					setState(189);
					match(T__5);
					}
				}

				setState(193);
				((OpAndAssignmentStatementContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
					((OpAndAssignmentStatementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(194);
				((OpAndAssignmentStatementContext)_localctx).rhs = expression(0);
				setState(195);
				match(T__3);
				}
				break;
			case 9:
				_localctx = new TryCatchStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(197);
				tryStatement();
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__34) {
					{
					setState(198);
					catchStatement();
					}
				}

				}
				break;
			case 10:
				_localctx = new FunctionCallStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(201);
				expression(0);
				setState(202);
				match(T__3);
				}
				break;
			case 11:
				_localctx = new AssemblyStatementContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(204);
				assembly();
				}
				break;
			case 12:
				_localctx = new AssertionStatementContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(205);
				assertion();
				}
				break;
			case 13:
				_localctx = new ExceptionStatementContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(206);
				exception();
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 22, RULE_elseifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__32);
			setState(210);
			match(T__20);
			setState(211);
			match(T__17);
			setState(212);
			((ElseifStatementContext)_localctx).conditional = expression(0);
			setState(213);
			match(T__18);
			setState(214);
			match(T__15);
			setState(215);
			statement();
			setState(216);
			match(T__16);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
		enterRule(_localctx, 24, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__32);
			setState(219);
			match(T__15);
			setState(220);
			statement();
			setState(221);
			match(T__16);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
		enterRule(_localctx, 26, RULE_tryStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__33);
			setState(224);
			match(T__15);
			setState(225);
			statement();
			setState(226);
			match(T__16);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
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
		enterRule(_localctx, 28, RULE_catchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__34);
			setState(229);
			match(T__17);
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << ID) | (1L << INT) | (1L << FLOAT))) != 0) || _la==STRING || _la==CHAR) {
				{
				setState(230);
				exprList();
				}
			}

			setState(233);
			match(T__18);
			setState(234);
			match(T__15);
			setState(235);
			statement();
			setState(236);
			match(T__16);
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
		enterRule(_localctx, 30, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
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
		enterRule(_localctx, 32, RULE_assembly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__35);
			setState(241);
			match(T__17);
			setState(242);
			match(STRING);
			setState(243);
			match(T__18);
			setState(244);
			match(T__3);
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
		enterRule(_localctx, 34, RULE_assertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__36);
			setState(247);
			match(T__17);
			setState(248);
			expression(0);
			setState(249);
			match(T__18);
			setState(250);
			match(T__3);
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
		enterRule(_localctx, 36, RULE_exception);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__37);
			setState(253);
			match(T__17);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << ID) | (1L << INT) | (1L << FLOAT))) != 0) || _la==STRING || _la==CHAR) {
				{
				setState(254);
				exprList();
				}
			}

			setState(257);
			match(T__18);
			setState(258);
			match(T__3);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new CastExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(261);
				match(T__17);
				setState(262);
				type();
				setState(263);
				match(T__18);
				setState(264);
				expression(23);
				}
				break;
			case 2:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				match(ID);
				setState(267);
				match(T__17);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << ID) | (1L << INT) | (1L << FLOAT))) != 0) || _la==STRING || _la==CHAR) {
					{
					setState(268);
					exprList();
					}
				}

				setState(271);
				match(T__18);
				}
				break;
			case 3:
				{
				_localctx = new ArrayAccessExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(272);
				match(ID);
				setState(273);
				match(T__4);
				setState(274);
				expression(0);
				setState(275);
				match(T__5);
				}
				break;
			case 4:
				{
				_localctx = new AddressOfVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				match(T__38);
				setState(278);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ValueAtVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(279);
				match(T__0);
				setState(280);
				expression(19);
				}
				break;
			case 6:
				{
				_localctx = new LengthOfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(281);
				match(T__39);
				setState(282);
				expression(18);
				}
				break;
			case 7:
				{
				_localctx = new SizeOfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				match(T__39);
				setState(284);
				type();
				}
				break;
			case 8:
				{
				_localctx = new NegateExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(T__40);
				setState(286);
				expression(16);
				}
				break;
			case 9:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287);
				match(T__41);
				setState(288);
				expression(15);
				}
				break;
			case 10:
				{
				_localctx = new VariableReferenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(289);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new NumberLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				number();
				}
				break;
			case 12:
				{
				_localctx = new BooleanLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				booleanLiteral();
				}
				break;
			case 13:
				{
				_localctx = new StringLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				match(STRING);
				}
				break;
			case 14:
				{
				_localctx = new CharLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293);
				match(CHAR);
				}
				break;
			case 15:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294);
				match(T__17);
				setState(295);
				expression(0);
				setState(296);
				match(T__18);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(329);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(327);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new ModuloExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ModuloExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(300);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						{
						setState(301);
						match(T__42);
						}
						setState(302);
						((ModuloExpressionContext)_localctx).rhs = expression(15);
						}
						break;
					case 2:
						{
						_localctx = new MultDivExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((MultDivExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(303);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(304);
						((MultDivExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__43 || _la==T__44) ) {
							((MultDivExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(305);
						((MultDivExpressionContext)_localctx).rhs = expression(14);
						}
						break;
					case 3:
						{
						_localctx = new AddSubExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(307);
						((AddSubExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__40 || _la==T__45) ) {
							((AddSubExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(308);
						((AddSubExpressionContext)_localctx).rhs = expression(13);
						}
						break;
					case 4:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((BitwiseExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(309);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(310);
						((BitwiseExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49))) != 0)) ) {
							((BitwiseExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(311);
						((BitwiseExpressionContext)_localctx).rhs = expression(12);
						}
						break;
					case 5:
						{
						_localctx = new AndOrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AndOrExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(313);
						((AndOrExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__50 || _la==T__51) ) {
							((AndOrExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(314);
						((AndOrExpressionContext)_localctx).rhs = expression(11);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(315);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(316);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55))) != 0)) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(317);
						((ComparisonExpressionContext)_localctx).rhs = expression(10);
						}
						break;
					case 7:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((EqualityExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(318);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(319);
						((EqualityExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__56 || _la==T__57) ) {
							((EqualityExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(320);
						((EqualityExpressionContext)_localctx).rhs = expression(9);
						}
						break;
					case 8:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((TernaryExpressionContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(321);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(322);
						match(T__58);
						setState(323);
						((TernaryExpressionContext)_localctx).iftrue = expression(0);
						setState(324);
						match(T__59);
						setState(325);
						((TernaryExpressionContext)_localctx).iffalse = expression(2);
						}
						break;
					}
					} 
				}
				setState(331);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 40, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
			expression(0);
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(333);
				match(T__19);
				setState(334);
				expression(0);
				}
				}
				setState(339);
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
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3F\u0157\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\6\2\60\n\2\r\2\16"+
		"\2\61\3\3\3\3\3\4\5\4\67\n\4\3\4\3\4\5\4;\n\4\3\4\3\4\3\4\5\4@\n\4\3\4"+
		"\3\4\3\4\3\4\5\4F\n\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4N\n\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4`\n\4\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\5\7h\n\7\3\7\3\7\3\b\3\b\3\b\3\b\5\bp\n\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\7\tx\n\t\f\t\16\t{\13\t\3\n\3\n\5\n\177\n\n\3\n\3\n\3\13\3\13"+
		"\7\13\u0085\n\13\f\13\16\13\u0088\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\7\f\u0094\n\f\f\f\16\f\u0097\13\f\3\f\5\f\u009a\n\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00af\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b7\n\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\5\f\u00c2\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ca\n\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00d2\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\5\20\u00ea\n\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\5\24\u0102\n\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0110"+
		"\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u012d\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\7\25\u014a\n\25\f\25\16\25\u014d\13\25\3\26\3\26\3\26\7\26"+
		"\u0152\n\26\f\26\16\26\u0155\13\26\3\26\2\3(\27\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*\2\f\3\2\n\16\3\2\17\21\3\2\34\"\3\2@A\3\2./\4\2"+
		"++\60\60\3\2\61\64\3\2\65\66\3\2\67:\3\2;<\2\u017d\2/\3\2\2\2\4\63\3\2"+
		"\2\2\6_\3\2\2\2\ba\3\2\2\2\nc\3\2\2\2\fe\3\2\2\2\16k\3\2\2\2\20t\3\2\2"+
		"\2\22|\3\2\2\2\24\u0082\3\2\2\2\26\u00d1\3\2\2\2\30\u00d3\3\2\2\2\32\u00dc"+
		"\3\2\2\2\34\u00e1\3\2\2\2\36\u00e6\3\2\2\2 \u00f0\3\2\2\2\"\u00f2\3\2"+
		"\2\2$\u00f8\3\2\2\2&\u00fe\3\2\2\2(\u012c\3\2\2\2*\u014e\3\2\2\2,\60\5"+
		"\16\b\2-\60\5\6\4\2.\60\5\26\f\2/,\3\2\2\2/-\3\2\2\2/.\3\2\2\2\60\61\3"+
		"\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\3\3\2\2\2\63\64\7\3\2\2\64\5\3\2\2"+
		"\2\65\67\7\4\2\2\66\65\3\2\2\2\66\67\3\2\2\2\678\3\2\2\28:\5\b\5\29;\5"+
		"\4\3\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<?\7?\2\2=>\7\5\2\2>@\5(\25\2?=\3"+
		"\2\2\2?@\3\2\2\2@A\3\2\2\2AB\7\6\2\2B`\3\2\2\2CE\5\b\5\2DF\5\4\3\2ED\3"+
		"\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7?\2\2HI\7\7\2\2IJ\7@\2\2JM\7\b\2\2KL\7\5"+
		"\2\2LN\5(\25\2MK\3\2\2\2MN\3\2\2\2NO\3\2\2\2OP\7\6\2\2P`\3\2\2\2QR\5\b"+
		"\5\2RS\7?\2\2ST\7\t\2\2TU\7\5\2\2UV\5\f\7\2VW\7\6\2\2W`\3\2\2\2XY\5\b"+
		"\5\2YZ\7?\2\2Z[\7\t\2\2[\\\7\5\2\2\\]\7B\2\2]^\7\6\2\2^`\3\2\2\2_\66\3"+
		"\2\2\2_C\3\2\2\2_Q\3\2\2\2_X\3\2\2\2`\7\3\2\2\2ab\t\2\2\2b\t\3\2\2\2c"+
		"d\t\3\2\2d\13\3\2\2\2eg\7\22\2\2fh\5*\26\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2"+
		"\2ij\7\23\2\2j\r\3\2\2\2kl\5\b\5\2lm\7?\2\2mo\7\24\2\2np\5\20\t\2on\3"+
		"\2\2\2op\3\2\2\2pq\3\2\2\2qr\7\25\2\2rs\5\24\13\2s\17\3\2\2\2ty\5\22\n"+
		"\2uv\7\26\2\2vx\5\22\n\2wu\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\21\3"+
		"\2\2\2{y\3\2\2\2|~\5\b\5\2}\177\5\4\3\2~}\3\2\2\2~\177\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0081\7?\2\2\u0081\23\3\2\2\2\u0082\u0086\7\22\2\2\u0083"+
		"\u0085\5\26\f\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3"+
		"\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\7\23\2\2\u008a\25\3\2\2\2\u008b\u00d2\5\24\13\2\u008c\u00d2\5\6"+
		"\4\2\u008d\u008e\7\27\2\2\u008e\u008f\5(\25\2\u008f\u0090\7\22\2\2\u0090"+
		"\u0091\5\26\f\2\u0091\u0095\7\23\2\2\u0092\u0094\5\30\r\2\u0093\u0092"+
		"\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\5\32\16\2\u0099\u0098\3"+
		"\2\2\2\u0099\u009a\3\2\2\2\u009a\u00d2\3\2\2\2\u009b\u009c\7\30\2\2\u009c"+
		"\u009d\7\24\2\2\u009d\u009e\7@\2\2\u009e\u009f\7\31\2\2\u009f\u00a0\5"+
		"\b\5\2\u00a0\u00a1\7?\2\2\u00a1\u00a2\7\25\2\2\u00a2\u00a3\5\26\f\2\u00a3"+
		"\u00d2\3\2\2\2\u00a4\u00a5\7\32\2\2\u00a5\u00a6\7\24\2\2\u00a6\u00a7\7"+
		"?\2\2\u00a7\u00a8\7\31\2\2\u00a8\u00a9\5\6\4\2\u00a9\u00aa\7\25\2\2\u00aa"+
		"\u00ab\5\26\f\2\u00ab\u00d2\3\2\2\2\u00ac\u00ae\7\33\2\2\u00ad\u00af\5"+
		"(\25\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00d2\7\6\2\2\u00b1\u00b6\7?\2\2\u00b2\u00b3\7\7\2\2\u00b3\u00b4\5(\25"+
		"\2\u00b4\u00b5\7\b\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\5\2\2\u00b9\u00ba\5(\25\2\u00ba"+
		"\u00bb\7\6\2\2\u00bb\u00d2\3\2\2\2\u00bc\u00c1\7?\2\2\u00bd\u00be\7\7"+
		"\2\2\u00be\u00bf\5(\25\2\u00bf\u00c0\7\b\2\2\u00c0\u00c2\3\2\2\2\u00c1"+
		"\u00bd\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\t\4"+
		"\2\2\u00c4\u00c5\5(\25\2\u00c5\u00c6\7\6\2\2\u00c6\u00d2\3\2\2\2\u00c7"+
		"\u00c9\5\34\17\2\u00c8\u00ca\5\36\20\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca"+
		"\3\2\2\2\u00ca\u00d2\3\2\2\2\u00cb\u00cc\5(\25\2\u00cc\u00cd\7\6\2\2\u00cd"+
		"\u00d2\3\2\2\2\u00ce\u00d2\5\"\22\2\u00cf\u00d2\5$\23\2\u00d0\u00d2\5"+
		"&\24\2\u00d1\u008b\3\2\2\2\u00d1\u008c\3\2\2\2\u00d1\u008d\3\2\2\2\u00d1"+
		"\u009b\3\2\2\2\u00d1\u00a4\3\2\2\2\u00d1\u00ac\3\2\2\2\u00d1\u00b1\3\2"+
		"\2\2\u00d1\u00bc\3\2\2\2\u00d1\u00c7\3\2\2\2\u00d1\u00cb\3\2\2\2\u00d1"+
		"\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\27\3\2\2"+
		"\2\u00d3\u00d4\7#\2\2\u00d4\u00d5\7\27\2\2\u00d5\u00d6\7\24\2\2\u00d6"+
		"\u00d7\5(\25\2\u00d7\u00d8\7\25\2\2\u00d8\u00d9\7\22\2\2\u00d9\u00da\5"+
		"\26\f\2\u00da\u00db\7\23\2\2\u00db\31\3\2\2\2\u00dc\u00dd\7#\2\2\u00dd"+
		"\u00de\7\22\2\2\u00de\u00df\5\26\f\2\u00df\u00e0\7\23\2\2\u00e0\33\3\2"+
		"\2\2\u00e1\u00e2\7$\2\2\u00e2\u00e3\7\22\2\2\u00e3\u00e4\5\26\f\2\u00e4"+
		"\u00e5\7\23\2\2\u00e5\35\3\2\2\2\u00e6\u00e7\7%\2\2\u00e7\u00e9\7\24\2"+
		"\2\u00e8\u00ea\5*\26\2\u00e9\u00e8\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb"+
		"\3\2\2\2\u00eb\u00ec\7\25\2\2\u00ec\u00ed\7\22\2\2\u00ed\u00ee\5\26\f"+
		"\2\u00ee\u00ef\7\23\2\2\u00ef\37\3\2\2\2\u00f0\u00f1\t\5\2\2\u00f1!\3"+
		"\2\2\2\u00f2\u00f3\7&\2\2\u00f3\u00f4\7\24\2\2\u00f4\u00f5\7B\2\2\u00f5"+
		"\u00f6\7\25\2\2\u00f6\u00f7\7\6\2\2\u00f7#\3\2\2\2\u00f8\u00f9\7\'\2\2"+
		"\u00f9\u00fa\7\24\2\2\u00fa\u00fb\5(\25\2\u00fb\u00fc\7\25\2\2\u00fc\u00fd"+
		"\7\6\2\2\u00fd%\3\2\2\2\u00fe\u00ff\7(\2\2\u00ff\u0101\7\24\2\2\u0100"+
		"\u0102\5*\26\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0104\7\25\2\2\u0104\u0105\7\6\2\2\u0105\'\3\2\2\2\u0106\u0107"+
		"\b\25\1\2\u0107\u0108\7\24\2\2\u0108\u0109\5\b\5\2\u0109\u010a\7\25\2"+
		"\2\u010a\u010b\5(\25\31\u010b\u012d\3\2\2\2\u010c\u010d\7?\2\2\u010d\u010f"+
		"\7\24\2\2\u010e\u0110\5*\26\2\u010f\u010e\3\2\2\2\u010f\u0110\3\2\2\2"+
		"\u0110\u0111\3\2\2\2\u0111\u012d\7\25\2\2\u0112\u0113\7?\2\2\u0113\u0114"+
		"\7\7\2\2\u0114\u0115\5(\25\2\u0115\u0116\7\b\2\2\u0116\u012d\3\2\2\2\u0117"+
		"\u0118\7)\2\2\u0118\u012d\7?\2\2\u0119\u011a\7\3\2\2\u011a\u012d\5(\25"+
		"\25\u011b\u011c\7*\2\2\u011c\u012d\5(\25\24\u011d\u011e\7*\2\2\u011e\u012d"+
		"\5\b\5\2\u011f\u0120\7+\2\2\u0120\u012d\5(\25\22\u0121\u0122\7,\2\2\u0122"+
		"\u012d\5(\25\21\u0123\u012d\7?\2\2\u0124\u012d\5 \21\2\u0125\u012d\5\n"+
		"\6\2\u0126\u012d\7B\2\2\u0127\u012d\7C\2\2\u0128\u0129\7\24\2\2\u0129"+
		"\u012a\5(\25\2\u012a\u012b\7\25\2\2\u012b\u012d\3\2\2\2\u012c\u0106\3"+
		"\2\2\2\u012c\u010c\3\2\2\2\u012c\u0112\3\2\2\2\u012c\u0117\3\2\2\2\u012c"+
		"\u0119\3\2\2\2\u012c\u011b\3\2\2\2\u012c\u011d\3\2\2\2\u012c\u011f\3\2"+
		"\2\2\u012c\u0121\3\2\2\2\u012c\u0123\3\2\2\2\u012c\u0124\3\2\2\2\u012c"+
		"\u0125\3\2\2\2\u012c\u0126\3\2\2\2\u012c\u0127\3\2\2\2\u012c\u0128\3\2"+
		"\2\2\u012d\u014b\3\2\2\2\u012e\u012f\f\20\2\2\u012f\u0130\7-\2\2\u0130"+
		"\u014a\5(\25\21\u0131\u0132\f\17\2\2\u0132\u0133\t\6\2\2\u0133\u014a\5"+
		"(\25\20\u0134\u0135\f\16\2\2\u0135\u0136\t\7\2\2\u0136\u014a\5(\25\17"+
		"\u0137\u0138\f\r\2\2\u0138\u0139\t\b\2\2\u0139\u014a\5(\25\16\u013a\u013b"+
		"\f\f\2\2\u013b\u013c\t\t\2\2\u013c\u014a\5(\25\r\u013d\u013e\f\13\2\2"+
		"\u013e\u013f\t\n\2\2\u013f\u014a\5(\25\f\u0140\u0141\f\n\2\2\u0141\u0142"+
		"\t\13\2\2\u0142\u014a\5(\25\13\u0143\u0144\f\3\2\2\u0144\u0145\7=\2\2"+
		"\u0145\u0146\5(\25\2\u0146\u0147\7>\2\2\u0147\u0148\5(\25\4\u0148\u014a"+
		"\3\2\2\2\u0149\u012e\3\2\2\2\u0149\u0131\3\2\2\2\u0149\u0134\3\2\2\2\u0149"+
		"\u0137\3\2\2\2\u0149\u013a\3\2\2\2\u0149\u013d\3\2\2\2\u0149\u0140\3\2"+
		"\2\2\u0149\u0143\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c)\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u0153\5(\25\2"+
		"\u014f\u0150\7\26\2\2\u0150\u0152\5(\25\2\u0151\u014f\3\2\2\2\u0152\u0155"+
		"\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154+\3\2\2\2\u0155"+
		"\u0153\3\2\2\2\35/\61\66:?EM_goy~\u0086\u0095\u0099\u00ae\u00b6\u00c1"+
		"\u00c9\u00d1\u00e9\u0101\u010f\u012c\u0149\u014b\u0153";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}