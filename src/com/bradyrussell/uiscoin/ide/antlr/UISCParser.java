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
		T__66=67, T__67=68, T__68=69, ID=70, INT=71, FLOAT=72, STRING=73, CHAR=74, 
		WS=75, SL_COMMENT=76, ML_COMMENT=77;
	public static final int
		RULE_file = 0, RULE_pointer = 1, RULE_varDeclaration = 2, RULE_structDeclaration = 3, 
		RULE_type = 4, RULE_booleanLiteral = 5, RULE_arrayInitializer = 6, RULE_functionDeclaration = 7, 
		RULE_formalParameters = 8, RULE_formalParameter = 9, RULE_block = 10, 
		RULE_statement = 11, RULE_elseifStatement = 12, RULE_elseStatement = 13, 
		RULE_tryStatement = 14, RULE_catchStatement = 15, RULE_number = 16, RULE_assembly = 17, 
		RULE_assertion = 18, RULE_exception = 19, RULE_include = 20, RULE_flag = 21, 
		RULE_flagData = 22, RULE_structField = 23, RULE_expression = 24, RULE_exprList = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "pointer", "varDeclaration", "structDeclaration", "type", "booleanLiteral", 
			"arrayInitializer", "functionDeclaration", "formalParameters", "formalParameter", 
			"block", "statement", "elseifStatement", "elseStatement", "tryStatement", 
			"catchStatement", "number", "assembly", "assertion", "exception", "include", 
			"flag", "flagData", "structField", "expression", "exprList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'@'", "'const'", "'='", "';'", "'['", "']'", "'[]'", "'struct'", 
			"'{'", "'}'", "'void'", "'byte'", "'int32'", "'int64'", "'float'", "'true'", 
			"'false'", "'null'", "'('", "')'", "','", "'if'", "'ufori'", "'as'", 
			"'uforeach'", "'while'", "'for'", "'return'", "'+='", "'-='", "'*='", 
			"'/='", "'%='", "'&='", "'|='", "'else'", "'try'", "'catch'", "'asm'", 
			"'assert'", "'throw'", "'include'", "'flag'", "'flagdata'", "'.'", "'$'", 
			"'#'", "'-'", "'!'", "'--'", "'++'", "'%'", "'*'", "'/'", "'+'", "'&'", 
			"'|'", "'^'", "'~'", "'&&'", "'||'", "'<'", "'<='", "'>'", "'>='", "'=='", 
			"'!='", "'?'", "':'"
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
			null, null, null, null, null, null, null, null, null, null, "ID", "INT", 
			"FLOAT", "STRING", "CHAR", "WS", "SL_COMMENT", "ML_COMMENT"
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
			setState(55); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(55);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(52);
					functionDeclaration();
					}
					break;
				case 2:
					{
					setState(53);
					varDeclaration();
					}
					break;
				case 3:
					{
					setState(54);
					statement();
					}
					break;
				}
				}
				setState(57); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__36) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0) );
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
			setState(59);
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
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new VarInitializationContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(61);
					((VarInitializationContext)_localctx).constant = match(T__1);
					}
				}

				setState(64);
				type();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(65);
					pointer();
					}
				}

				setState(68);
				match(ID);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(69);
					match(T__2);
					setState(70);
					expression(0);
					}
				}

				setState(73);
				match(T__3);
				}
				break;
			case 2:
				_localctx = new ArrayAssignmentInitializationContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				type();
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(76);
					pointer();
					}
				}

				setState(79);
				match(ID);
				setState(80);
				match(T__4);
				setState(81);
				((ArrayAssignmentInitializationContext)_localctx).size = match(INT);
				setState(82);
				match(T__5);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(83);
					match(T__2);
					setState(84);
					expression(0);
					}
				}

				setState(87);
				match(T__3);
				}
				break;
			case 3:
				_localctx = new ArrayValueInitializationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				type();
				setState(90);
				match(ID);
				setState(91);
				match(T__6);
				setState(92);
				match(T__2);
				setState(93);
				arrayInitializer();
				setState(94);
				match(T__3);
				}
				break;
			case 4:
				_localctx = new ArrayStringInitializationContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				type();
				setState(97);
				match(ID);
				setState(98);
				match(T__6);
				setState(99);
				match(T__2);
				setState(100);
				match(STRING);
				setState(101);
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
			setState(105);
			match(T__7);
			setState(106);
			match(ID);
			setState(107);
			match(T__8);
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				varDeclaration();
				}
				}
				setState(111); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0) );
			setState(113);
			match(T__9);
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
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
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
		enterRule(_localctx, 10, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
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
		enterRule(_localctx, 12, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(T__8);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0)) {
				{
				setState(120);
				exprList();
				}
			}

			setState(123);
			match(T__9);
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
		enterRule(_localctx, 14, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			type();
			setState(126);
			match(ID);
			setState(127);
			match(T__18);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) {
				{
				setState(128);
				formalParameters();
				}
			}

			setState(131);
			match(T__19);
			setState(132);
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
		enterRule(_localctx, 16, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			formalParameter();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(135);
				match(T__20);
				setState(136);
				formalParameter();
				}
				}
				setState(141);
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
		enterRule(_localctx, 18, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			type();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(143);
				pointer();
				}
			}

			setState(146);
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
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(T__8);
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__36) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0)) {
				{
				{
				setState(149);
				statement();
				}
				}
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(155);
			match(T__9);
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				block();
				}
				break;
			case 2:
				_localctx = new VarDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				varDeclaration();
				}
				break;
			case 3:
				_localctx = new StructDeclarationStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				structDeclaration();
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				match(T__21);
				setState(161);
				((IfStatementContext)_localctx).conditional = expression(0);
				setState(162);
				match(T__8);
				setState(164); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(163);
					((IfStatementContext)_localctx).ifbody = statement();
					}
					}
					setState(166); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__36) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0) );
				setState(168);
				match(T__9);
				setState(172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(169);
						elseifStatement();
						}
						} 
					}
					setState(174);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__35) {
					{
					setState(175);
					elseStatement();
					}
				}

				}
				break;
			case 5:
				_localctx = new UforiStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(178);
				match(T__22);
				setState(179);
				match(T__18);
				setState(180);
				((UforiStatementContext)_localctx).iterations = match(INT);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__20) {
					{
					setState(181);
					match(T__20);
					setState(182);
					((UforiStatementContext)_localctx).iterationsEnd = match(INT);
					}
				}

				setState(185);
				match(T__23);
				setState(186);
				type();
				setState(187);
				match(ID);
				setState(188);
				match(T__19);
				setState(190); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(189);
						((UforiStatementContext)_localctx).forbody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(192); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 6:
				_localctx = new UforeachStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(194);
				match(T__24);
				setState(195);
				match(T__18);
				setState(196);
				((UforeachStatementContext)_localctx).arrayToLoop = match(ID);
				setState(197);
				match(T__23);
				setState(198);
				varDeclaration();
				setState(199);
				match(T__19);
				setState(201); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(200);
						((UforeachStatementContext)_localctx).forbody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(203); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 7:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(205);
				match(T__25);
				setState(206);
				match(T__18);
				setState(207);
				expression(0);
				setState(208);
				match(T__19);
				setState(210); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(209);
						((WhileStatementContext)_localctx).whilebody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(212); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 8:
				_localctx = new ForStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(214);
				match(T__26);
				setState(215);
				match(T__18);
				setState(216);
				varDeclaration();
				setState(217);
				((ForStatementContext)_localctx).conditional = expression(0);
				setState(218);
				match(T__3);
				setState(219);
				((ForStatementContext)_localctx).afterEach = statement();
				setState(220);
				match(T__19);
				setState(222); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(221);
						((ForStatementContext)_localctx).forbody = statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(224); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 9:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(226);
				match(T__27);
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0)) {
					{
					setState(227);
					((ReturnStatementContext)_localctx).retval = expression(0);
					}
				}

				setState(230);
				match(T__3);
				}
				break;
			case 10:
				_localctx = new AssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(233);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(231);
					((AssignmentStatementContext)_localctx).lhs = match(ID);
					}
					break;
				case 2:
					{
					setState(232);
					((AssignmentStatementContext)_localctx).lhs_struct = structField();
					}
					break;
				}
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(235);
					match(T__4);
					setState(236);
					((AssignmentStatementContext)_localctx).arrayIndex = expression(0);
					setState(237);
					match(T__5);
					}
				}

				setState(241);
				match(T__2);
				setState(242);
				((AssignmentStatementContext)_localctx).rhs = expression(0);
				setState(243);
				match(T__3);
				}
				break;
			case 11:
				_localctx = new OpAndAssignmentStatementContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(245);
				((OpAndAssignmentStatementContext)_localctx).lhs = match(ID);
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__4) {
					{
					setState(246);
					match(T__4);
					setState(247);
					((OpAndAssignmentStatementContext)_localctx).arrayIndex = expression(0);
					setState(248);
					match(T__5);
					}
				}

				setState(252);
				((OpAndAssignmentStatementContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34))) != 0)) ) {
					((OpAndAssignmentStatementContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(253);
				((OpAndAssignmentStatementContext)_localctx).rhs = expression(0);
				setState(254);
				match(T__3);
				}
				break;
			case 12:
				_localctx = new TryCatchStatementContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(256);
				tryStatement();
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__37) {
					{
					setState(257);
					catchStatement();
					}
				}

				}
				break;
			case 13:
				_localctx = new FunctionCallStatementContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(260);
				expression(0);
				setState(261);
				match(T__3);
				}
				break;
			case 14:
				_localctx = new AssemblyStatementContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(263);
				assembly();
				}
				break;
			case 15:
				_localctx = new AssertionStatementContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(264);
				assertion();
				}
				break;
			case 16:
				_localctx = new ExceptionStatementContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(265);
				exception();
				}
				break;
			case 17:
				_localctx = new IncludeStatementContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(266);
				include();
				}
				break;
			case 18:
				_localctx = new FlagStatementContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(267);
				flag();
				}
				break;
			case 19:
				_localctx = new FlagDataStatementContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(268);
				flagData();
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
		enterRule(_localctx, 24, RULE_elseifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(T__35);
			setState(272);
			match(T__21);
			setState(273);
			match(T__18);
			setState(274);
			((ElseifStatementContext)_localctx).conditional = expression(0);
			setState(275);
			match(T__19);
			setState(276);
			match(T__8);
			setState(278); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(277);
				statement();
				}
				}
				setState(280); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__36) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0) );
			setState(282);
			match(T__9);
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
		enterRule(_localctx, 26, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(T__35);
			setState(285);
			match(T__8);
			setState(287); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(286);
				statement();
				}
				}
				setState(289); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__36) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0) );
			setState(291);
			match(T__9);
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
		enterRule(_localctx, 28, RULE_tryStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(T__36);
			setState(294);
			match(T__8);
			setState(296); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(295);
				statement();
				}
				}
				setState(298); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__36) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0) );
			setState(300);
			match(T__9);
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
		enterRule(_localctx, 30, RULE_catchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(T__37);
			setState(303);
			match(T__18);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0)) {
				{
				setState(304);
				exprList();
				}
			}

			setState(307);
			match(T__19);
			setState(308);
			match(T__8);
			setState(310); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(309);
				statement();
				}
				}
				setState(312); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__7) | (1L << T__8) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__22) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__36) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0) );
			setState(314);
			match(T__9);
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
		enterRule(_localctx, 32, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
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
		enterRule(_localctx, 34, RULE_assembly);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(T__38);
			setState(319);
			match(T__18);
			setState(320);
			match(STRING);
			setState(321);
			match(T__19);
			setState(322);
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
		enterRule(_localctx, 36, RULE_assertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			match(T__39);
			setState(325);
			match(T__18);
			setState(326);
			expression(0);
			setState(327);
			match(T__19);
			setState(328);
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
		enterRule(_localctx, 38, RULE_exception);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(T__40);
			setState(331);
			match(T__18);
			setState(333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0)) {
				{
				setState(332);
				exprList();
				}
			}

			setState(335);
			match(T__19);
			setState(336);
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
		enterRule(_localctx, 40, RULE_include);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			match(T__41);
			setState(339);
			match(T__18);
			setState(340);
			match(STRING);
			setState(341);
			match(T__19);
			setState(342);
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
		enterRule(_localctx, 42, RULE_flag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(T__42);
			setState(345);
			match(T__18);
			setState(346);
			match(INT);
			setState(347);
			match(T__19);
			setState(348);
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
		enterRule(_localctx, 44, RULE_flagData);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(T__43);
			setState(351);
			match(T__18);
			setState(352);
			match(STRING);
			setState(353);
			match(T__19);
			setState(354);
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
		enterRule(_localctx, 46, RULE_structField);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			((StructFieldContext)_localctx).structname = match(ID);
			setState(359); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(357);
					match(T__44);
					setState(358);
					((StructFieldContext)_localctx).fieldname = match(ID);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(361); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				_localctx = new CastExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(364);
				match(T__18);
				setState(365);
				type();
				setState(366);
				match(T__19);
				setState(367);
				expression(26);
				}
				break;
			case 2:
				{
				_localctx = new FunctionCallExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(369);
				match(ID);
				setState(370);
				match(T__18);
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50))) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (ID - 70)) | (1L << (INT - 70)) | (1L << (FLOAT - 70)) | (1L << (STRING - 70)) | (1L << (CHAR - 70)))) != 0)) {
					{
					setState(371);
					exprList();
					}
				}

				setState(374);
				match(T__19);
				}
				break;
			case 3:
				{
				_localctx = new ArrayAccessExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(375);
				match(ID);
				setState(376);
				match(T__4);
				setState(377);
				expression(0);
				setState(378);
				match(T__5);
				}
				break;
			case 4:
				{
				_localctx = new AddressOfVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(380);
				match(T__45);
				setState(381);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ValueAtVariableExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(382);
				match(T__0);
				setState(383);
				expression(22);
				}
				break;
			case 6:
				{
				_localctx = new LengthOfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(384);
				match(T__46);
				setState(385);
				expression(21);
				}
				break;
			case 7:
				{
				_localctx = new SizeOfExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(386);
				match(T__46);
				setState(387);
				type();
				}
				break;
			case 8:
				{
				_localctx = new NegateExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(388);
				match(T__47);
				setState(389);
				expression(19);
				}
				break;
			case 9:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(390);
				match(T__48);
				setState(391);
				expression(18);
				}
				break;
			case 10:
				{
				_localctx = new PrefixOpExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(392);
				((PrefixOpExpressionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__49 || _la==T__50) ) {
					((PrefixOpExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(393);
				expression(17);
				}
				break;
			case 11:
				{
				_localctx = new VariableReferenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(394);
				match(ID);
				}
				break;
			case 12:
				{
				_localctx = new StructFieldReferenceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(395);
				structField();
				}
				break;
			case 13:
				{
				_localctx = new NumberLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(396);
				number();
				}
				break;
			case 14:
				{
				_localctx = new BooleanLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(397);
				booleanLiteral();
				}
				break;
			case 15:
				{
				_localctx = new StringLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(398);
				match(STRING);
				}
				break;
			case 16:
				{
				_localctx = new CharLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(399);
				match(CHAR);
				}
				break;
			case 17:
				{
				_localctx = new ParenExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(400);
				match(T__18);
				setState(401);
				expression(0);
				setState(402);
				match(T__19);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(437);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(435);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new ModuloExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ModuloExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(406);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						{
						setState(407);
						match(T__51);
						}
						setState(408);
						((ModuloExpressionContext)_localctx).rhs = expression(16);
						}
						break;
					case 2:
						{
						_localctx = new MultDivExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((MultDivExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(409);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(410);
						((MultDivExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__52 || _la==T__53) ) {
							((MultDivExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(411);
						((MultDivExpressionContext)_localctx).rhs = expression(15);
						}
						break;
					case 3:
						{
						_localctx = new AddSubExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AddSubExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(412);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(413);
						((AddSubExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__47 || _la==T__54) ) {
							((AddSubExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(414);
						((AddSubExpressionContext)_localctx).rhs = expression(14);
						}
						break;
					case 4:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((BitwiseExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(415);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(416);
						((BitwiseExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58))) != 0)) ) {
							((BitwiseExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(417);
						((BitwiseExpressionContext)_localctx).rhs = expression(13);
						}
						break;
					case 5:
						{
						_localctx = new AndOrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((AndOrExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(418);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(419);
						((AndOrExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__59 || _la==T__60) ) {
							((AndOrExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(420);
						((AndOrExpressionContext)_localctx).rhs = expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((ComparisonExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(421);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(422);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & ((1L << (T__61 - 62)) | (1L << (T__62 - 62)) | (1L << (T__63 - 62)) | (1L << (T__64 - 62)))) != 0)) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(423);
						((ComparisonExpressionContext)_localctx).rhs = expression(11);
						}
						break;
					case 7:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((EqualityExpressionContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(424);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(425);
						((EqualityExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__65 || _la==T__66) ) {
							((EqualityExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(426);
						((EqualityExpressionContext)_localctx).rhs = expression(10);
						}
						break;
					case 8:
						{
						_localctx = new TernaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						((TernaryExpressionContext)_localctx).condition = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(427);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(428);
						match(T__67);
						setState(429);
						((TernaryExpressionContext)_localctx).iftrue = expression(0);
						setState(430);
						match(T__68);
						setState(431);
						((TernaryExpressionContext)_localctx).iffalse = expression(2);
						}
						break;
					case 9:
						{
						_localctx = new PostfixOpExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(433);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(434);
						((PostfixOpExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__49 || _la==T__50) ) {
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
				setState(439);
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
		enterRule(_localctx, 50, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			expression(0);
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(441);
				match(T__20);
				setState(442);
				expression(0);
				}
				}
				setState(447);
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
		case 24:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3O\u01c3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\6\2:\n\2\r\2\16\2;\3\3\3\3\3\4\5\4A\n"+
		"\4\3\4\3\4\5\4E\n\4\3\4\3\4\3\4\5\4J\n\4\3\4\3\4\3\4\3\4\5\4P\n\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\5\4X\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\5\4j\n\4\3\5\3\5\3\5\3\5\6\5p\n\5\r\5\16\5q\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\5\b|\n\b\3\b\3\b\3\t\3\t\3\t\3\t\5\t\u0084"+
		"\n\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u008c\n\n\f\n\16\n\u008f\13\n\3\13\3"+
		"\13\5\13\u0093\n\13\3\13\3\13\3\f\3\f\7\f\u0099\n\f\f\f\16\f\u009c\13"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u00a7\n\r\r\r\16\r\u00a8\3"+
		"\r\3\r\7\r\u00ad\n\r\f\r\16\r\u00b0\13\r\3\r\5\r\u00b3\n\r\3\r\3\r\3\r"+
		"\3\r\3\r\5\r\u00ba\n\r\3\r\3\r\3\r\3\r\3\r\6\r\u00c1\n\r\r\r\16\r\u00c2"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\6\r\u00cc\n\r\r\r\16\r\u00cd\3\r\3\r\3\r"+
		"\3\r\3\r\6\r\u00d5\n\r\r\r\16\r\u00d6\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\6\r\u00e1\n\r\r\r\16\r\u00e2\3\r\3\r\5\r\u00e7\n\r\3\r\3\r\3\r\5\r\u00ec"+
		"\n\r\3\r\3\r\3\r\3\r\5\r\u00f2\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u00fd\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0105\n\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u0110\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\6"+
		"\16\u0119\n\16\r\16\16\16\u011a\3\16\3\16\3\17\3\17\3\17\6\17\u0122\n"+
		"\17\r\17\16\17\u0123\3\17\3\17\3\20\3\20\3\20\6\20\u012b\n\20\r\20\16"+
		"\20\u012c\3\20\3\20\3\21\3\21\3\21\5\21\u0134\n\21\3\21\3\21\3\21\6\21"+
		"\u0139\n\21\r\21\16\21\u013a\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u0150\n\25"+
		"\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\6\31\u016a\n\31\r\31"+
		"\16\31\u016b\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0177\n"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\5\32\u0197\n\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u01b6\n\32\f\32\16\32\u01b9\13"+
		"\32\3\33\3\33\3\33\7\33\u01be\n\33\f\33\16\33\u01c1\13\33\3\33\2\3\62"+
		"\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\2\r\3\2\r"+
		"\21\3\2\22\24\3\2\37%\3\2IJ\3\2\64\65\3\2\678\4\2\62\6299\3\2:=\3\2>?"+
		"\3\2@C\3\2DE\2\u01fa\29\3\2\2\2\4=\3\2\2\2\6i\3\2\2\2\bk\3\2\2\2\nu\3"+
		"\2\2\2\fw\3\2\2\2\16y\3\2\2\2\20\177\3\2\2\2\22\u0088\3\2\2\2\24\u0090"+
		"\3\2\2\2\26\u0096\3\2\2\2\30\u010f\3\2\2\2\32\u0111\3\2\2\2\34\u011e\3"+
		"\2\2\2\36\u0127\3\2\2\2 \u0130\3\2\2\2\"\u013e\3\2\2\2$\u0140\3\2\2\2"+
		"&\u0146\3\2\2\2(\u014c\3\2\2\2*\u0154\3\2\2\2,\u015a\3\2\2\2.\u0160\3"+
		"\2\2\2\60\u0166\3\2\2\2\62\u0196\3\2\2\2\64\u01ba\3\2\2\2\66:\5\20\t\2"+
		"\67:\5\6\4\28:\5\30\r\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2:;\3\2\2\2;9"+
		"\3\2\2\2;<\3\2\2\2<\3\3\2\2\2=>\7\3\2\2>\5\3\2\2\2?A\7\4\2\2@?\3\2\2\2"+
		"@A\3\2\2\2AB\3\2\2\2BD\5\n\6\2CE\5\4\3\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2"+
		"FI\7H\2\2GH\7\5\2\2HJ\5\62\32\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\6\2"+
		"\2Lj\3\2\2\2MO\5\n\6\2NP\5\4\3\2ON\3\2\2\2OP\3\2\2\2PQ\3\2\2\2QR\7H\2"+
		"\2RS\7\7\2\2ST\7I\2\2TW\7\b\2\2UV\7\5\2\2VX\5\62\32\2WU\3\2\2\2WX\3\2"+
		"\2\2XY\3\2\2\2YZ\7\6\2\2Zj\3\2\2\2[\\\5\n\6\2\\]\7H\2\2]^\7\t\2\2^_\7"+
		"\5\2\2_`\5\16\b\2`a\7\6\2\2aj\3\2\2\2bc\5\n\6\2cd\7H\2\2de\7\t\2\2ef\7"+
		"\5\2\2fg\7K\2\2gh\7\6\2\2hj\3\2\2\2i@\3\2\2\2iM\3\2\2\2i[\3\2\2\2ib\3"+
		"\2\2\2j\7\3\2\2\2kl\7\n\2\2lm\7H\2\2mo\7\13\2\2np\5\6\4\2on\3\2\2\2pq"+
		"\3\2\2\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\f\2\2t\t\3\2\2\2uv\t\2\2\2"+
		"v\13\3\2\2\2wx\t\3\2\2x\r\3\2\2\2y{\7\13\2\2z|\5\64\33\2{z\3\2\2\2{|\3"+
		"\2\2\2|}\3\2\2\2}~\7\f\2\2~\17\3\2\2\2\177\u0080\5\n\6\2\u0080\u0081\7"+
		"H\2\2\u0081\u0083\7\25\2\2\u0082\u0084\5\22\n\2\u0083\u0082\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\7\26\2\2\u0086\u0087\5"+
		"\26\f\2\u0087\21\3\2\2\2\u0088\u008d\5\24\13\2\u0089\u008a\7\27\2\2\u008a"+
		"\u008c\5\24\13\2\u008b\u0089\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3"+
		"\2\2\2\u008d\u008e\3\2\2\2\u008e\23\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0092\5\n\6\2\u0091\u0093\5\4\3\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7H\2\2\u0095\25\3\2\2\2\u0096\u009a"+
		"\7\13\2\2\u0097\u0099\5\30\r\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2"+
		"\u009a\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009d\u009e\7\f\2\2\u009e\27\3\2\2\2\u009f\u0110\5\26\f\2\u00a0"+
		"\u0110\5\6\4\2\u00a1\u0110\5\b\5\2\u00a2\u00a3\7\30\2\2\u00a3\u00a4\5"+
		"\62\32\2\u00a4\u00a6\7\13\2\2\u00a5\u00a7\5\30\r\2\u00a6\u00a5\3\2\2\2"+
		"\u00a7\u00a8\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa"+
		"\3\2\2\2\u00aa\u00ae\7\f\2\2\u00ab\u00ad\5\32\16\2\u00ac\u00ab\3\2\2\2"+
		"\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b2"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b3\5\34\17\2\u00b2\u00b1\3\2\2\2"+
		"\u00b2\u00b3\3\2\2\2\u00b3\u0110\3\2\2\2\u00b4\u00b5\7\31\2\2\u00b5\u00b6"+
		"\7\25\2\2\u00b6\u00b9\7I\2\2\u00b7\u00b8\7\27\2\2\u00b8\u00ba\7I\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\32"+
		"\2\2\u00bc\u00bd\5\n\6\2\u00bd\u00be\7H\2\2\u00be\u00c0\7\26\2\2\u00bf"+
		"\u00c1\5\30\r\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3"+
		"\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u0110\3\2\2\2\u00c4\u00c5\7\33\2\2\u00c5"+
		"\u00c6\7\25\2\2\u00c6\u00c7\7H\2\2\u00c7\u00c8\7\32\2\2\u00c8\u00c9\5"+
		"\6\4\2\u00c9\u00cb\7\26\2\2\u00ca\u00cc\5\30\r\2\u00cb\u00ca\3\2\2\2\u00cc"+
		"\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u0110\3\2"+
		"\2\2\u00cf\u00d0\7\34\2\2\u00d0\u00d1\7\25\2\2\u00d1\u00d2\5\62\32\2\u00d2"+
		"\u00d4\7\26\2\2\u00d3\u00d5\5\30\r\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3"+
		"\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u0110\3\2\2\2\u00d8"+
		"\u00d9\7\35\2\2\u00d9\u00da\7\25\2\2\u00da\u00db\5\6\4\2\u00db\u00dc\5"+
		"\62\32\2\u00dc\u00dd\7\6\2\2\u00dd\u00de\5\30\r\2\u00de\u00e0\7\26\2\2"+
		"\u00df\u00e1\5\30\r\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u0110\3\2\2\2\u00e4\u00e6\7\36\2\2"+
		"\u00e5\u00e7\5\62\32\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8"+
		"\3\2\2\2\u00e8\u0110\7\6\2\2\u00e9\u00ec\7H\2\2\u00ea\u00ec\5\60\31\2"+
		"\u00eb\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00f1\3\2\2\2\u00ed\u00ee"+
		"\7\7\2\2\u00ee\u00ef\5\62\32\2\u00ef\u00f0\7\b\2\2\u00f0\u00f2\3\2\2\2"+
		"\u00f1\u00ed\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4"+
		"\7\5\2\2\u00f4\u00f5\5\62\32\2\u00f5\u00f6\7\6\2\2\u00f6\u0110\3\2\2\2"+
		"\u00f7\u00fc\7H\2\2\u00f8\u00f9\7\7\2\2\u00f9\u00fa\5\62\32\2\u00fa\u00fb"+
		"\7\b\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00f8\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00ff\t\4\2\2\u00ff\u0100\5\62\32\2\u0100\u0101\7"+
		"\6\2\2\u0101\u0110\3\2\2\2\u0102\u0104\5\36\20\2\u0103\u0105\5 \21\2\u0104"+
		"\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0110\3\2\2\2\u0106\u0107\5\62"+
		"\32\2\u0107\u0108\7\6\2\2\u0108\u0110\3\2\2\2\u0109\u0110\5$\23\2\u010a"+
		"\u0110\5&\24\2\u010b\u0110\5(\25\2\u010c\u0110\5*\26\2\u010d\u0110\5,"+
		"\27\2\u010e\u0110\5.\30\2\u010f\u009f\3\2\2\2\u010f\u00a0\3\2\2\2\u010f"+
		"\u00a1\3\2\2\2\u010f\u00a2\3\2\2\2\u010f\u00b4\3\2\2\2\u010f\u00c4\3\2"+
		"\2\2\u010f\u00cf\3\2\2\2\u010f\u00d8\3\2\2\2\u010f\u00e4\3\2\2\2\u010f"+
		"\u00eb\3\2\2\2\u010f\u00f7\3\2\2\2\u010f\u0102\3\2\2\2\u010f\u0106\3\2"+
		"\2\2\u010f\u0109\3\2\2\2\u010f\u010a\3\2\2\2\u010f\u010b\3\2\2\2\u010f"+
		"\u010c\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110\31\3\2\2"+
		"\2\u0111\u0112\7&\2\2\u0112\u0113\7\30\2\2\u0113\u0114\7\25\2\2\u0114"+
		"\u0115\5\62\32\2\u0115\u0116\7\26\2\2\u0116\u0118\7\13\2\2\u0117\u0119"+
		"\5\30\r\2\u0118\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u0118\3\2\2\2"+
		"\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\7\f\2\2\u011d\33"+
		"\3\2\2\2\u011e\u011f\7&\2\2\u011f\u0121\7\13\2\2\u0120\u0122\5\30\r\2"+
		"\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124"+
		"\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\7\f\2\2\u0126\35\3\2\2\2\u0127"+
		"\u0128\7\'\2\2\u0128\u012a\7\13\2\2\u0129\u012b\5\30\r\2\u012a\u0129\3"+
		"\2\2\2\u012b\u012c\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u012f\7\f\2\2\u012f\37\3\2\2\2\u0130\u0131\7(\2\2"+
		"\u0131\u0133\7\25\2\2\u0132\u0134\5\64\33\2\u0133\u0132\3\2\2\2\u0133"+
		"\u0134\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\7\26\2\2\u0136\u0138\7"+
		"\13\2\2\u0137\u0139\5\30\r\2\u0138\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013d\7\f"+
		"\2\2\u013d!\3\2\2\2\u013e\u013f\t\5\2\2\u013f#\3\2\2\2\u0140\u0141\7)"+
		"\2\2\u0141\u0142\7\25\2\2\u0142\u0143\7K\2\2\u0143\u0144\7\26\2\2\u0144"+
		"\u0145\7\6\2\2\u0145%\3\2\2\2\u0146\u0147\7*\2\2\u0147\u0148\7\25\2\2"+
		"\u0148\u0149\5\62\32\2\u0149\u014a\7\26\2\2\u014a\u014b\7\6\2\2\u014b"+
		"\'\3\2\2\2\u014c\u014d\7+\2\2\u014d\u014f\7\25\2\2\u014e\u0150\5\64\33"+
		"\2\u014f\u014e\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u0152"+
		"\7\26\2\2\u0152\u0153\7\6\2\2\u0153)\3\2\2\2\u0154\u0155\7,\2\2\u0155"+
		"\u0156\7\25\2\2\u0156\u0157\7K\2\2\u0157\u0158\7\26\2\2\u0158\u0159\7"+
		"\6\2\2\u0159+\3\2\2\2\u015a\u015b\7-\2\2\u015b\u015c\7\25\2\2\u015c\u015d"+
		"\7I\2\2\u015d\u015e\7\26\2\2\u015e\u015f\7\6\2\2\u015f-\3\2\2\2\u0160"+
		"\u0161\7.\2\2\u0161\u0162\7\25\2\2\u0162\u0163\7K\2\2\u0163\u0164\7\26"+
		"\2\2\u0164\u0165\7\6\2\2\u0165/\3\2\2\2\u0166\u0169\7H\2\2\u0167\u0168"+
		"\7/\2\2\u0168\u016a\7H\2\2\u0169\u0167\3\2\2\2\u016a\u016b\3\2\2\2\u016b"+
		"\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c\61\3\2\2\2\u016d\u016e\b\32\1"+
		"\2\u016e\u016f\7\25\2\2\u016f\u0170\5\n\6\2\u0170\u0171\7\26\2\2\u0171"+
		"\u0172\5\62\32\34\u0172\u0197\3\2\2\2\u0173\u0174\7H\2\2\u0174\u0176\7"+
		"\25\2\2\u0175\u0177\5\64\33\2\u0176\u0175\3\2\2\2\u0176\u0177\3\2\2\2"+
		"\u0177\u0178\3\2\2\2\u0178\u0197\7\26\2\2\u0179\u017a\7H\2\2\u017a\u017b"+
		"\7\7\2\2\u017b\u017c\5\62\32\2\u017c\u017d\7\b\2\2\u017d\u0197\3\2\2\2"+
		"\u017e\u017f\7\60\2\2\u017f\u0197\7H\2\2\u0180\u0181\7\3\2\2\u0181\u0197"+
		"\5\62\32\30\u0182\u0183\7\61\2\2\u0183\u0197\5\62\32\27\u0184\u0185\7"+
		"\61\2\2\u0185\u0197\5\n\6\2\u0186\u0187\7\62\2\2\u0187\u0197\5\62\32\25"+
		"\u0188\u0189\7\63\2\2\u0189\u0197\5\62\32\24\u018a\u018b\t\6\2\2\u018b"+
		"\u0197\5\62\32\23\u018c\u0197\7H\2\2\u018d\u0197\5\60\31\2\u018e\u0197"+
		"\5\"\22\2\u018f\u0197\5\f\7\2\u0190\u0197\7K\2\2\u0191\u0197\7L\2\2\u0192"+
		"\u0193\7\25\2\2\u0193\u0194\5\62\32\2\u0194\u0195\7\26\2\2\u0195\u0197"+
		"\3\2\2\2\u0196\u016d\3\2\2\2\u0196\u0173\3\2\2\2\u0196\u0179\3\2\2\2\u0196"+
		"\u017e\3\2\2\2\u0196\u0180\3\2\2\2\u0196\u0182\3\2\2\2\u0196\u0184\3\2"+
		"\2\2\u0196\u0186\3\2\2\2\u0196\u0188\3\2\2\2\u0196\u018a\3\2\2\2\u0196"+
		"\u018c\3\2\2\2\u0196\u018d\3\2\2\2\u0196\u018e\3\2\2\2\u0196\u018f\3\2"+
		"\2\2\u0196\u0190\3\2\2\2\u0196\u0191\3\2\2\2\u0196\u0192\3\2\2\2\u0197"+
		"\u01b7\3\2\2\2\u0198\u0199\f\21\2\2\u0199\u019a\7\66\2\2\u019a\u01b6\5"+
		"\62\32\22\u019b\u019c\f\20\2\2\u019c\u019d\t\7\2\2\u019d\u01b6\5\62\32"+
		"\21\u019e\u019f\f\17\2\2\u019f\u01a0\t\b\2\2\u01a0\u01b6\5\62\32\20\u01a1"+
		"\u01a2\f\16\2\2\u01a2\u01a3\t\t\2\2\u01a3\u01b6\5\62\32\17\u01a4\u01a5"+
		"\f\r\2\2\u01a5\u01a6\t\n\2\2\u01a6\u01b6\5\62\32\16\u01a7\u01a8\f\f\2"+
		"\2\u01a8\u01a9\t\13\2\2\u01a9\u01b6\5\62\32\r\u01aa\u01ab\f\13\2\2\u01ab"+
		"\u01ac\t\f\2\2\u01ac\u01b6\5\62\32\f\u01ad\u01ae\f\3\2\2\u01ae\u01af\7"+
		"F\2\2\u01af\u01b0\5\62\32\2\u01b0\u01b1\7G\2\2\u01b1\u01b2\5\62\32\4\u01b2"+
		"\u01b6\3\2\2\2\u01b3\u01b4\f\22\2\2\u01b4\u01b6\t\6\2\2\u01b5\u0198\3"+
		"\2\2\2\u01b5\u019b\3\2\2\2\u01b5\u019e\3\2\2\2\u01b5\u01a1\3\2\2\2\u01b5"+
		"\u01a4\3\2\2\2\u01b5\u01a7\3\2\2\2\u01b5\u01aa\3\2\2\2\u01b5\u01ad\3\2"+
		"\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5\3\2\2\2\u01b7"+
		"\u01b8\3\2\2\2\u01b8\63\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba\u01bf\5\62\32"+
		"\2\u01bb\u01bc\7\27\2\2\u01bc\u01be\5\62\32\2\u01bd\u01bb\3\2\2\2\u01be"+
		"\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\65\3\2\2"+
		"\2\u01c1\u01bf\3\2\2\2*9;@DIOWiq{\u0083\u008d\u0092\u009a\u00a8\u00ae"+
		"\u00b2\u00b9\u00c2\u00cd\u00d6\u00e2\u00e6\u00eb\u00f1\u00fc\u0104\u010f"+
		"\u011a\u0123\u012c\u0133\u013a\u014f\u016b\u0176\u0196\u01b5\u01b7\u01bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}