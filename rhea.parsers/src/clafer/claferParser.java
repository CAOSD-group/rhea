// Generated from clafer\claferParser.g4 by ANTLR 4.8
package clafer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class claferParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Surrogate_id_SYMB_0=1, Surrogate_id_SYMB_1=2, Surrogate_id_SYMB_2=3, Surrogate_id_SYMB_3=4, 
		Surrogate_id_SYMB_4=5, Surrogate_id_SYMB_5=6, Surrogate_id_SYMB_6=7, Surrogate_id_SYMB_7=8, 
		Surrogate_id_SYMB_8=9, Surrogate_id_SYMB_9=10, Surrogate_id_SYMB_10=11, 
		Surrogate_id_SYMB_11=12, Surrogate_id_SYMB_12=13, Surrogate_id_SYMB_13=14, 
		Surrogate_id_SYMB_14=15, Surrogate_id_SYMB_15=16, Surrogate_id_SYMB_16=17, 
		Surrogate_id_SYMB_17=18, Surrogate_id_SYMB_18=19, Surrogate_id_SYMB_19=20, 
		Surrogate_id_SYMB_20=21, Surrogate_id_SYMB_21=22, Surrogate_id_SYMB_22=23, 
		Surrogate_id_SYMB_23=24, Surrogate_id_SYMB_24=25, Surrogate_id_SYMB_25=26, 
		Surrogate_id_SYMB_26=27, Surrogate_id_SYMB_27=28, Surrogate_id_SYMB_28=29, 
		Surrogate_id_SYMB_29=30, Surrogate_id_SYMB_30=31, Surrogate_id_SYMB_31=32, 
		Surrogate_id_SYMB_32=33, Surrogate_id_SYMB_33=34, Surrogate_id_SYMB_34=35, 
		Surrogate_id_SYMB_35=36, Surrogate_id_SYMB_36=37, Surrogate_id_SYMB_37=38, 
		Surrogate_id_SYMB_38=39, Surrogate_id_SYMB_39=40, Surrogate_id_SYMB_40=41, 
		Surrogate_id_SYMB_41=42, Surrogate_id_SYMB_42=43, Surrogate_id_SYMB_43=44, 
		Surrogate_id_SYMB_44=45, Surrogate_id_SYMB_45=46, Surrogate_id_SYMB_46=47, 
		Surrogate_id_SYMB_47=48, Surrogate_id_SYMB_48=49, Surrogate_id_SYMB_49=50, 
		Surrogate_id_SYMB_50=51, Surrogate_id_SYMB_51=52, Surrogate_id_SYMB_52=53, 
		Surrogate_id_SYMB_53=54, Surrogate_id_SYMB_54=55, Surrogate_id_SYMB_55=56, 
		Surrogate_id_SYMB_56=57, Surrogate_id_SYMB_57=58, Surrogate_id_SYMB_58=59, 
		Surrogate_id_SYMB_59=60, Surrogate_id_SYMB_60=61, Surrogate_id_SYMB_61=62, 
		Surrogate_id_SYMB_62=63, Surrogate_id_SYMB_63=64, Surrogate_id_SYMB_64=65, 
		Surrogate_id_SYMB_65=66, Surrogate_id_SYMB_66=67, Surrogate_id_SYMB_67=68, 
		Surrogate_id_SYMB_68=69, Surrogate_id_SYMB_69=70, Surrogate_id_SYMB_70=71, 
		Surrogate_id_SYMB_71=72, Surrogate_id_SYMB_72=73, Surrogate_id_SYMB_73=74, 
		Surrogate_id_SYMB_74=75, Surrogate_id_SYMB_75=76, Surrogate_id_SYMB_76=77, 
		Surrogate_id_SYMB_77=78, Surrogate_id_SYMB_78=79, Surrogate_id_SYMB_79=80, 
		Surrogate_id_SYMB_80=81, Surrogate_id_SYMB_81=82, Surrogate_id_SYMB_82=83, 
		Surrogate_id_SYMB_83=84, Surrogate_id_SYMB_84=85, Surrogate_id_SYMB_85=86, 
		Surrogate_id_SYMB_86=87, Surrogate_id_SYMB_87=88, Surrogate_id_SYMB_88=89, 
		Surrogate_id_SYMB_89=90, Surrogate_id_SYMB_90=91, Surrogate_id_SYMB_91=92, 
		Surrogate_id_SYMB_92=93, Surrogate_id_SYMB_93=94, Surrogate_id_SYMB_94=95, 
		Surrogate_id_SYMB_95=96, Surrogate_id_SYMB_96=97, Surrogate_id_SYMB_97=98, 
		Surrogate_id_SYMB_98=99, Surrogate_id_SYMB_99=100, PosInteger=101, PosDouble=102, 
		PosReal=103, PosString=104, PosIdent=105, PosLineComment=106, PosBlockComment=107, 
		PosAlloy=108, PosChoco=109, WS=110, ErrorToken=111;
	public static final int
		RULE_start_Module = 0, RULE_start_Clafer = 1, RULE_start_Constraint = 2, 
		RULE_start_Assertion = 3, RULE_start_Goal = 4, RULE_module = 5, RULE_declaration = 6, 
		RULE_clafer = 7, RULE_constraint = 8, RULE_assertion = 9, RULE_goal = 10, 
		RULE_tempModifier = 11, RULE_transition = 12, RULE_abstract_ = 13, RULE_elements = 14, 
		RULE_element = 15, RULE_super_ = 16, RULE_reference = 17, RULE_init = 18, 
		RULE_initHow = 19, RULE_gCard = 20, RULE_card = 21, RULE_nCard = 22, RULE_exInteger = 23, 
		RULE_name = 24, RULE_exp = 25, RULE_exp1 = 26, RULE_exp2 = 27, RULE_exp3 = 28, 
		RULE_exp4 = 29, RULE_exp5 = 30, RULE_exp6 = 31, RULE_exp7 = 32, RULE_exp8 = 33, 
		RULE_exp9 = 34, RULE_exp10 = 35, RULE_exp11 = 36, RULE_exp15 = 37, RULE_exp16 = 38, 
		RULE_exp17 = 39, RULE_exp18 = 40, RULE_exp19 = 41, RULE_exp20 = 42, RULE_exp21 = 43, 
		RULE_exp22 = 44, RULE_exp23 = 45, RULE_exp24 = 46, RULE_exp25 = 47, RULE_exp26 = 48, 
		RULE_exp27 = 49, RULE_transGuard = 50, RULE_transArrow = 51, RULE_patternScope = 52, 
		RULE_decl = 53, RULE_varBinding = 54, RULE_quant = 55, RULE_enumId = 56, 
		RULE_modId = 57, RULE_locId = 58, RULE_listDeclaration = 59, RULE_listEnumId = 60, 
		RULE_listElement = 61, RULE_listExp = 62, RULE_listTempModifier = 63, 
		RULE_listLocId = 64, RULE_listModId = 65, RULE_exp12 = 66, RULE_exp13 = 67, 
		RULE_exp14 = 68;
	private static String[] makeRuleNames() {
		return new String[] {
			"start_Module", "start_Clafer", "start_Constraint", "start_Assertion", 
			"start_Goal", "module", "declaration", "clafer", "constraint", "assertion", 
			"goal", "tempModifier", "transition", "abstract_", "elements", "element", 
			"super_", "reference", "init", "initHow", "gCard", "card", "nCard", "exInteger", 
			"name", "exp", "exp1", "exp2", "exp3", "exp4", "exp5", "exp6", "exp7", 
			"exp8", "exp9", "exp10", "exp11", "exp15", "exp16", "exp17", "exp18", 
			"exp19", "exp20", "exp21", "exp22", "exp23", "exp24", "exp25", "exp26", 
			"exp27", "transGuard", "transArrow", "patternScope", "decl", "varBinding", 
			"quant", "enumId", "modId", "locId", "listDeclaration", "listEnumId", 
			"listElement", "listExp", "listTempModifier", "listLocId", "listModId", 
			"exp12", "exp13", "exp14"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'['", "']'", "'<<'", "'>>'", "'{'", "'}'", "'`'", "':'", 
			"'->'", "'->>'", "':='", "'?'", "'+'", "'*'", "'..'", "'|'", "'<=>'", 
			"'=>'", "'||'", "'&&'", "'!'", "'<'", "'>'", "'<='", "'>='", "'!='", 
			"'-'", "'/'", "'%'", "'#'", "'<:'", "':>'", "'++'", "','", "'--'", "'**'", 
			"'&'", "'.'", "'-->>'", "'-['", "']->>'", "'-->'", "']->'", "';'", "'\\'", 
			"'('", "')'", "'F'", "'G'", "'U'", "'W'", "'X'", "'abstract'", "'after'", 
			"'all'", "'always'", "'and'", "'assert'", "'before'", "'between'", "'disj'", 
			"'else'", "'enum'", "'eventually'", "'final'", "'finally'", "'finalref'", 
			"'finaltarget'", "'follow'", "'globally'", "'if'", "'in'", "'initial'", 
			"'initially'", "'let'", "'lonce'", "'lone'", "'max'", "'maximize'", "'min'", 
			"'minimize'", "'must'", "'mux'", "'never'", "'next'", "'no'", "'not'", 
			"'one'", "'opt'", "'or'", "'precede'", "'product'", "'some'", "'sometime'", 
			"'sum'", "'then'", "'until'", "'weakuntil'", "'xor'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Surrogate_id_SYMB_0", "Surrogate_id_SYMB_1", "Surrogate_id_SYMB_2", 
			"Surrogate_id_SYMB_3", "Surrogate_id_SYMB_4", "Surrogate_id_SYMB_5", 
			"Surrogate_id_SYMB_6", "Surrogate_id_SYMB_7", "Surrogate_id_SYMB_8", 
			"Surrogate_id_SYMB_9", "Surrogate_id_SYMB_10", "Surrogate_id_SYMB_11", 
			"Surrogate_id_SYMB_12", "Surrogate_id_SYMB_13", "Surrogate_id_SYMB_14", 
			"Surrogate_id_SYMB_15", "Surrogate_id_SYMB_16", "Surrogate_id_SYMB_17", 
			"Surrogate_id_SYMB_18", "Surrogate_id_SYMB_19", "Surrogate_id_SYMB_20", 
			"Surrogate_id_SYMB_21", "Surrogate_id_SYMB_22", "Surrogate_id_SYMB_23", 
			"Surrogate_id_SYMB_24", "Surrogate_id_SYMB_25", "Surrogate_id_SYMB_26", 
			"Surrogate_id_SYMB_27", "Surrogate_id_SYMB_28", "Surrogate_id_SYMB_29", 
			"Surrogate_id_SYMB_30", "Surrogate_id_SYMB_31", "Surrogate_id_SYMB_32", 
			"Surrogate_id_SYMB_33", "Surrogate_id_SYMB_34", "Surrogate_id_SYMB_35", 
			"Surrogate_id_SYMB_36", "Surrogate_id_SYMB_37", "Surrogate_id_SYMB_38", 
			"Surrogate_id_SYMB_39", "Surrogate_id_SYMB_40", "Surrogate_id_SYMB_41", 
			"Surrogate_id_SYMB_42", "Surrogate_id_SYMB_43", "Surrogate_id_SYMB_44", 
			"Surrogate_id_SYMB_45", "Surrogate_id_SYMB_46", "Surrogate_id_SYMB_47", 
			"Surrogate_id_SYMB_48", "Surrogate_id_SYMB_49", "Surrogate_id_SYMB_50", 
			"Surrogate_id_SYMB_51", "Surrogate_id_SYMB_52", "Surrogate_id_SYMB_53", 
			"Surrogate_id_SYMB_54", "Surrogate_id_SYMB_55", "Surrogate_id_SYMB_56", 
			"Surrogate_id_SYMB_57", "Surrogate_id_SYMB_58", "Surrogate_id_SYMB_59", 
			"Surrogate_id_SYMB_60", "Surrogate_id_SYMB_61", "Surrogate_id_SYMB_62", 
			"Surrogate_id_SYMB_63", "Surrogate_id_SYMB_64", "Surrogate_id_SYMB_65", 
			"Surrogate_id_SYMB_66", "Surrogate_id_SYMB_67", "Surrogate_id_SYMB_68", 
			"Surrogate_id_SYMB_69", "Surrogate_id_SYMB_70", "Surrogate_id_SYMB_71", 
			"Surrogate_id_SYMB_72", "Surrogate_id_SYMB_73", "Surrogate_id_SYMB_74", 
			"Surrogate_id_SYMB_75", "Surrogate_id_SYMB_76", "Surrogate_id_SYMB_77", 
			"Surrogate_id_SYMB_78", "Surrogate_id_SYMB_79", "Surrogate_id_SYMB_80", 
			"Surrogate_id_SYMB_81", "Surrogate_id_SYMB_82", "Surrogate_id_SYMB_83", 
			"Surrogate_id_SYMB_84", "Surrogate_id_SYMB_85", "Surrogate_id_SYMB_86", 
			"Surrogate_id_SYMB_87", "Surrogate_id_SYMB_88", "Surrogate_id_SYMB_89", 
			"Surrogate_id_SYMB_90", "Surrogate_id_SYMB_91", "Surrogate_id_SYMB_92", 
			"Surrogate_id_SYMB_93", "Surrogate_id_SYMB_94", "Surrogate_id_SYMB_95", 
			"Surrogate_id_SYMB_96", "Surrogate_id_SYMB_97", "Surrogate_id_SYMB_98", 
			"Surrogate_id_SYMB_99", "PosInteger", "PosDouble", "PosReal", "PosString", 
			"PosIdent", "PosLineComment", "PosBlockComment", "PosAlloy", "PosChoco", 
			"WS", "ErrorToken"
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
	public String getGrammarFileName() { return "claferParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	public claferParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Start_ModuleContext extends ParserRuleContext {
		public clafer.Absyn.Module result;
		public ModuleContext x;
		public TerminalNode EOF() { return getToken(claferParser.EOF, 0); }
		public ModuleContext module() {
			return getRuleContext(ModuleContext.class,0);
		}
		public Start_ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_Module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterStart_Module(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitStart_Module(this);
		}
	}

	public final Start_ModuleContext start_Module() throws RecognitionException {
		Start_ModuleContext _localctx = new Start_ModuleContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start_Module);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			((Start_ModuleContext)_localctx).x = module();
			setState(139);
			match(EOF);
			 ((Start_ModuleContext)_localctx).result =  ((Start_ModuleContext)_localctx).x.result; 
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

	public static class Start_ClaferContext extends ParserRuleContext {
		public clafer.Absyn.Clafer result;
		public ClaferContext x;
		public TerminalNode EOF() { return getToken(claferParser.EOF, 0); }
		public ClaferContext clafer() {
			return getRuleContext(ClaferContext.class,0);
		}
		public Start_ClaferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_Clafer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterStart_Clafer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitStart_Clafer(this);
		}
	}

	public final Start_ClaferContext start_Clafer() throws RecognitionException {
		Start_ClaferContext _localctx = new Start_ClaferContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_start_Clafer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			((Start_ClaferContext)_localctx).x = clafer();
			setState(143);
			match(EOF);
			 ((Start_ClaferContext)_localctx).result =  ((Start_ClaferContext)_localctx).x.result; 
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

	public static class Start_ConstraintContext extends ParserRuleContext {
		public clafer.Absyn.Constraint result;
		public ConstraintContext x;
		public TerminalNode EOF() { return getToken(claferParser.EOF, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public Start_ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_Constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterStart_Constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitStart_Constraint(this);
		}
	}

	public final Start_ConstraintContext start_Constraint() throws RecognitionException {
		Start_ConstraintContext _localctx = new Start_ConstraintContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_start_Constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			((Start_ConstraintContext)_localctx).x = constraint();
			setState(147);
			match(EOF);
			 ((Start_ConstraintContext)_localctx).result =  ((Start_ConstraintContext)_localctx).x.result; 
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

	public static class Start_AssertionContext extends ParserRuleContext {
		public clafer.Absyn.Assertion result;
		public AssertionContext x;
		public TerminalNode EOF() { return getToken(claferParser.EOF, 0); }
		public AssertionContext assertion() {
			return getRuleContext(AssertionContext.class,0);
		}
		public Start_AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_Assertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterStart_Assertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitStart_Assertion(this);
		}
	}

	public final Start_AssertionContext start_Assertion() throws RecognitionException {
		Start_AssertionContext _localctx = new Start_AssertionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_start_Assertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			((Start_AssertionContext)_localctx).x = assertion();
			setState(151);
			match(EOF);
			 ((Start_AssertionContext)_localctx).result =  ((Start_AssertionContext)_localctx).x.result; 
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

	public static class Start_GoalContext extends ParserRuleContext {
		public clafer.Absyn.Goal result;
		public GoalContext x;
		public TerminalNode EOF() { return getToken(claferParser.EOF, 0); }
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
		public Start_GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start_Goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterStart_Goal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitStart_Goal(this);
		}
	}

	public final Start_GoalContext start_Goal() throws RecognitionException {
		Start_GoalContext _localctx = new Start_GoalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_start_Goal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			((Start_GoalContext)_localctx).x = goal();
			setState(155);
			match(EOF);
			 ((Start_GoalContext)_localctx).result =  ((Start_GoalContext)_localctx).x.result; 
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

	public static class ModuleContext extends ParserRuleContext {
		public clafer.Absyn.Module result;
		public ListDeclarationContext p_1_1;
		public ListDeclarationContext listDeclaration() {
			return getRuleContext(ListDeclarationContext.class,0);
		}
		public ModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitModule(this);
		}
	}

	public final ModuleContext module() throws RecognitionException {
		ModuleContext _localctx = new ModuleContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_module);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			((ModuleContext)_localctx).p_1_1 = listDeclaration(0);
			 ((ModuleContext)_localctx).result =  new clafer.Absyn.MModule(((ModuleContext)_localctx).p_1_1.result); 
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

	public static class DeclarationContext extends ParserRuleContext {
		public clafer.Absyn.Declaration result;
		public Token p_1_2;
		public ListEnumIdContext p_1_4;
		public ElementContext p_2_1;
		public TerminalNode Surrogate_id_SYMB_63() { return getToken(claferParser.Surrogate_id_SYMB_63, 0); }
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(claferParser.Surrogate_id_SYMB_0, 0); }
		public TerminalNode PosIdent() { return getToken(claferParser.PosIdent, 0); }
		public ListEnumIdContext listEnumId() {
			return getRuleContext(ListEnumIdContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaration);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				match(Surrogate_id_SYMB_63);
				setState(162);
				((DeclarationContext)_localctx).p_1_2 = match(PosIdent);
				setState(163);
				match(Surrogate_id_SYMB_0);
				setState(164);
				((DeclarationContext)_localctx).p_1_4 = listEnumId();
				 ((DeclarationContext)_localctx).result =  new clafer.Absyn.EnumDecl(((DeclarationContext)_localctx).p_1_2.getText(),((DeclarationContext)_localctx).p_1_4.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(167);
				((DeclarationContext)_localctx).p_2_1 = element();
				 ((DeclarationContext)_localctx).result =  new clafer.Absyn.ElementDecl(((DeclarationContext)_localctx).p_2_1.result); 
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

	public static class ClaferContext extends ParserRuleContext {
		public clafer.Absyn.Clafer result;
		public Abstract_Context p_1_1;
		public ListTempModifierContext p_1_2;
		public GCardContext p_1_3;
		public Token p_1_4;
		public Super_Context p_1_5;
		public ReferenceContext p_1_6;
		public CardContext p_1_7;
		public InitContext p_1_8;
		public TransitionContext p_1_9;
		public ElementsContext p_1_10;
		public Abstract_Context abstract_() {
			return getRuleContext(Abstract_Context.class,0);
		}
		public ListTempModifierContext listTempModifier() {
			return getRuleContext(ListTempModifierContext.class,0);
		}
		public GCardContext gCard() {
			return getRuleContext(GCardContext.class,0);
		}
		public TerminalNode PosIdent() { return getToken(claferParser.PosIdent, 0); }
		public Super_Context super_() {
			return getRuleContext(Super_Context.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public CardContext card() {
			return getRuleContext(CardContext.class,0);
		}
		public InitContext init() {
			return getRuleContext(InitContext.class,0);
		}
		public TransitionContext transition() {
			return getRuleContext(TransitionContext.class,0);
		}
		public ElementsContext elements() {
			return getRuleContext(ElementsContext.class,0);
		}
		public ClaferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clafer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterClafer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitClafer(this);
		}
	}

	public final ClaferContext clafer() throws RecognitionException {
		ClaferContext _localctx = new ClaferContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_clafer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			((ClaferContext)_localctx).p_1_1 = abstract_();
			setState(173);
			((ClaferContext)_localctx).p_1_2 = listTempModifier(0);
			setState(174);
			((ClaferContext)_localctx).p_1_3 = gCard();
			setState(175);
			((ClaferContext)_localctx).p_1_4 = match(PosIdent);
			setState(176);
			((ClaferContext)_localctx).p_1_5 = super_();
			setState(177);
			((ClaferContext)_localctx).p_1_6 = reference();
			setState(178);
			((ClaferContext)_localctx).p_1_7 = card();
			setState(179);
			((ClaferContext)_localctx).p_1_8 = init();
			setState(180);
			((ClaferContext)_localctx).p_1_9 = transition();
			setState(181);
			((ClaferContext)_localctx).p_1_10 = elements();
			 ((ClaferContext)_localctx).result =  new clafer.Absyn.CClafer(((ClaferContext)_localctx).p_1_1.result,((ClaferContext)_localctx).p_1_2.result,((ClaferContext)_localctx).p_1_3.result,((ClaferContext)_localctx).p_1_4.getText(),((ClaferContext)_localctx).p_1_5.result,((ClaferContext)_localctx).p_1_6.result,((ClaferContext)_localctx).p_1_7.result,((ClaferContext)_localctx).p_1_8.result,((ClaferContext)_localctx).p_1_9.result,((ClaferContext)_localctx).p_1_10.result); 
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

	public static class ConstraintContext extends ParserRuleContext {
		public clafer.Absyn.Constraint result;
		public ListExpContext p_1_2;
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(claferParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(claferParser.Surrogate_id_SYMB_2, 0); }
		public ListExpContext listExp() {
			return getRuleContext(ListExpContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitConstraint(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(Surrogate_id_SYMB_1);
			setState(185);
			((ConstraintContext)_localctx).p_1_2 = listExp(0);
			setState(186);
			match(Surrogate_id_SYMB_2);
			 ((ConstraintContext)_localctx).result =  new clafer.Absyn.CConstraint(((ConstraintContext)_localctx).p_1_2.result); 
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
		public clafer.Absyn.Assertion result;
		public ListExpContext p_1_3;
		public TerminalNode Surrogate_id_SYMB_58() { return getToken(claferParser.Surrogate_id_SYMB_58, 0); }
		public TerminalNode Surrogate_id_SYMB_1() { return getToken(claferParser.Surrogate_id_SYMB_1, 0); }
		public TerminalNode Surrogate_id_SYMB_2() { return getToken(claferParser.Surrogate_id_SYMB_2, 0); }
		public ListExpContext listExp() {
			return getRuleContext(ListExpContext.class,0);
		}
		public AssertionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterAssertion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitAssertion(this);
		}
	}

	public final AssertionContext assertion() throws RecognitionException {
		AssertionContext _localctx = new AssertionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assertion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(Surrogate_id_SYMB_58);
			setState(190);
			match(Surrogate_id_SYMB_1);
			setState(191);
			((AssertionContext)_localctx).p_1_3 = listExp(0);
			setState(192);
			match(Surrogate_id_SYMB_2);
			 ((AssertionContext)_localctx).result =  new clafer.Absyn.AAssertion(((AssertionContext)_localctx).p_1_3.result); 
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

	public static class GoalContext extends ParserRuleContext {
		public clafer.Absyn.Goal result;
		public ListExpContext p_1_3;
		public ListExpContext p_2_3;
		public ListExpContext p_3_3;
		public ListExpContext p_4_3;
		public TerminalNode Surrogate_id_SYMB_3() { return getToken(claferParser.Surrogate_id_SYMB_3, 0); }
		public TerminalNode Surrogate_id_SYMB_80() { return getToken(claferParser.Surrogate_id_SYMB_80, 0); }
		public TerminalNode Surrogate_id_SYMB_4() { return getToken(claferParser.Surrogate_id_SYMB_4, 0); }
		public ListExpContext listExp() {
			return getRuleContext(ListExpContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_78() { return getToken(claferParser.Surrogate_id_SYMB_78, 0); }
		public TerminalNode Surrogate_id_SYMB_81() { return getToken(claferParser.Surrogate_id_SYMB_81, 0); }
		public TerminalNode Surrogate_id_SYMB_79() { return getToken(claferParser.Surrogate_id_SYMB_79, 0); }
		public GoalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterGoal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitGoal(this);
		}
	}

	public final GoalContext goal() throws RecognitionException {
		GoalContext _localctx = new GoalContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_goal);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(Surrogate_id_SYMB_3);
				setState(196);
				match(Surrogate_id_SYMB_80);
				setState(197);
				((GoalContext)_localctx).p_1_3 = listExp(0);
				setState(198);
				match(Surrogate_id_SYMB_4);
				 ((GoalContext)_localctx).result =  new clafer.Absyn.GoalMinDeprecated(((GoalContext)_localctx).p_1_3.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(Surrogate_id_SYMB_3);
				setState(202);
				match(Surrogate_id_SYMB_78);
				setState(203);
				((GoalContext)_localctx).p_2_3 = listExp(0);
				setState(204);
				match(Surrogate_id_SYMB_4);
				 ((GoalContext)_localctx).result =  new clafer.Absyn.GoalMaxDeprecated(((GoalContext)_localctx).p_2_3.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(Surrogate_id_SYMB_3);
				setState(208);
				match(Surrogate_id_SYMB_81);
				setState(209);
				((GoalContext)_localctx).p_3_3 = listExp(0);
				setState(210);
				match(Surrogate_id_SYMB_4);
				 ((GoalContext)_localctx).result =  new clafer.Absyn.GoalMinimize(((GoalContext)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(213);
				match(Surrogate_id_SYMB_3);
				setState(214);
				match(Surrogate_id_SYMB_79);
				setState(215);
				((GoalContext)_localctx).p_4_3 = listExp(0);
				setState(216);
				match(Surrogate_id_SYMB_4);
				 ((GoalContext)_localctx).result =  new clafer.Absyn.GoalMaximize(((GoalContext)_localctx).p_4_3.result); 
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

	public static class TempModifierContext extends ParserRuleContext {
		public clafer.Absyn.TempModifier result;
		public TerminalNode Surrogate_id_SYMB_73() { return getToken(claferParser.Surrogate_id_SYMB_73, 0); }
		public TerminalNode Surrogate_id_SYMB_65() { return getToken(claferParser.Surrogate_id_SYMB_65, 0); }
		public TerminalNode Surrogate_id_SYMB_67() { return getToken(claferParser.Surrogate_id_SYMB_67, 0); }
		public TerminalNode Surrogate_id_SYMB_68() { return getToken(claferParser.Surrogate_id_SYMB_68, 0); }
		public TempModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tempModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterTempModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitTempModifier(this);
		}
	}

	public final TempModifierContext tempModifier() throws RecognitionException {
		TempModifierContext _localctx = new TempModifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tempModifier);
		try {
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_73:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(Surrogate_id_SYMB_73);
				 ((TempModifierContext)_localctx).result =  new clafer.Absyn.Initial(); 
				}
				break;
			case Surrogate_id_SYMB_65:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(Surrogate_id_SYMB_65);
				 ((TempModifierContext)_localctx).result =  new clafer.Absyn.Final(); 
				}
				break;
			case Surrogate_id_SYMB_67:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				match(Surrogate_id_SYMB_67);
				 ((TempModifierContext)_localctx).result =  new clafer.Absyn.FinalRef(); 
				}
				break;
			case Surrogate_id_SYMB_68:
				enterOuterAlt(_localctx, 4);
				{
				setState(227);
				match(Surrogate_id_SYMB_68);
				 ((TempModifierContext)_localctx).result =  new clafer.Absyn.FinalTarget(); 
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

	public static class TransitionContext extends ParserRuleContext {
		public clafer.Absyn.Transition result;
		public TransArrowContext p_2_1;
		public ExpContext p_2_2;
		public TransArrowContext transArrow() {
			return getRuleContext(TransArrowContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TransitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterTransition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitTransition(this);
		}
	}

	public final TransitionContext transition() throws RecognitionException {
		TransitionContext _localctx = new TransitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_transition);
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((TransitionContext)_localctx).result =  new clafer.Absyn.TransitionEmpty(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(232);
				((TransitionContext)_localctx).p_2_1 = transArrow();
				setState(233);
				((TransitionContext)_localctx).p_2_2 = exp();
				 ((TransitionContext)_localctx).result =  new clafer.Absyn.TTransition(((TransitionContext)_localctx).p_2_1.result,((TransitionContext)_localctx).p_2_2.result); 
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

	public static class Abstract_Context extends ParserRuleContext {
		public clafer.Absyn.Abstract result;
		public TerminalNode Surrogate_id_SYMB_53() { return getToken(claferParser.Surrogate_id_SYMB_53, 0); }
		public Abstract_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_abstract_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterAbstract_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitAbstract_(this);
		}
	}

	public final Abstract_Context abstract_() throws RecognitionException {
		Abstract_Context _localctx = new Abstract_Context(_ctx, getState());
		enterRule(_localctx, 26, RULE_abstract_);
		try {
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((Abstract_Context)_localctx).result =  new clafer.Absyn.AbstractEmpty(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				match(Surrogate_id_SYMB_53);
				 ((Abstract_Context)_localctx).result =  new clafer.Absyn.AAbstract(); 
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

	public static class ElementsContext extends ParserRuleContext {
		public clafer.Absyn.Elements result;
		public ListElementContext p_2_2;
		public TerminalNode Surrogate_id_SYMB_5() { return getToken(claferParser.Surrogate_id_SYMB_5, 0); }
		public TerminalNode Surrogate_id_SYMB_6() { return getToken(claferParser.Surrogate_id_SYMB_6, 0); }
		public ListElementContext listElement() {
			return getRuleContext(ListElementContext.class,0);
		}
		public ElementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterElements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitElements(this);
		}
	}

	public final ElementsContext elements() throws RecognitionException {
		ElementsContext _localctx = new ElementsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elements);
		try {
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((ElementsContext)_localctx).result =  new clafer.Absyn.ElementsEmpty(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				match(Surrogate_id_SYMB_5);
				setState(245);
				((ElementsContext)_localctx).p_2_2 = listElement(0);
				setState(246);
				match(Surrogate_id_SYMB_6);
				 ((ElementsContext)_localctx).result =  new clafer.Absyn.ElementsList(((ElementsContext)_localctx).p_2_2.result); 
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

	public static class ElementContext extends ParserRuleContext {
		public clafer.Absyn.Element result;
		public ClaferContext p_1_1;
		public NameContext p_2_2;
		public CardContext p_2_3;
		public ElementsContext p_2_4;
		public ConstraintContext p_3_1;
		public GoalContext p_4_1;
		public AssertionContext p_5_1;
		public ClaferContext clafer() {
			return getRuleContext(ClaferContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_7() { return getToken(claferParser.Surrogate_id_SYMB_7, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public CardContext card() {
			return getRuleContext(CardContext.class,0);
		}
		public ElementsContext elements() {
			return getRuleContext(ElementsContext.class,0);
		}
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public GoalContext goal() {
			return getRuleContext(GoalContext.class,0);
		}
		public AssertionContext assertion() {
			return getRuleContext(AssertionContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_element);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				((ElementContext)_localctx).p_1_1 = clafer();
				 ((ElementContext)_localctx).result =  new clafer.Absyn.Subclafer(((ElementContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(254);
				match(Surrogate_id_SYMB_7);
				setState(255);
				((ElementContext)_localctx).p_2_2 = name();
				setState(256);
				((ElementContext)_localctx).p_2_3 = card();
				setState(257);
				((ElementContext)_localctx).p_2_4 = elements();
				 ((ElementContext)_localctx).result =  new clafer.Absyn.ClaferUse(((ElementContext)_localctx).p_2_2.result,((ElementContext)_localctx).p_2_3.result,((ElementContext)_localctx).p_2_4.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(260);
				((ElementContext)_localctx).p_3_1 = constraint();
				 ((ElementContext)_localctx).result =  new clafer.Absyn.Subconstraint(((ElementContext)_localctx).p_3_1.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(263);
				((ElementContext)_localctx).p_4_1 = goal();
				 ((ElementContext)_localctx).result =  new clafer.Absyn.Subgoal(((ElementContext)_localctx).p_4_1.result); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(266);
				((ElementContext)_localctx).p_5_1 = assertion();
				 ((ElementContext)_localctx).result =  new clafer.Absyn.SubAssertion(((ElementContext)_localctx).p_5_1.result); 
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

	public static class Super_Context extends ParserRuleContext {
		public clafer.Absyn.Super result;
		public Exp26Context p_2_2;
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(claferParser.Surrogate_id_SYMB_8, 0); }
		public Exp26Context exp26() {
			return getRuleContext(Exp26Context.class,0);
		}
		public Super_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_super_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterSuper_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitSuper_(this);
		}
	}

	public final Super_Context super_() throws RecognitionException {
		Super_Context _localctx = new Super_Context(_ctx, getState());
		enterRule(_localctx, 32, RULE_super_);
		try {
			setState(276);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((Super_Context)_localctx).result =  new clafer.Absyn.SuperEmpty(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				match(Surrogate_id_SYMB_8);
				setState(273);
				((Super_Context)_localctx).p_2_2 = exp26(0);
				 ((Super_Context)_localctx).result =  new clafer.Absyn.SuperSome(((Super_Context)_localctx).p_2_2.result); 
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

	public static class ReferenceContext extends ParserRuleContext {
		public clafer.Absyn.Reference result;
		public Exp23Context p_2_2;
		public Exp23Context p_3_2;
		public TerminalNode Surrogate_id_SYMB_9() { return getToken(claferParser.Surrogate_id_SYMB_9, 0); }
		public Exp23Context exp23() {
			return getRuleContext(Exp23Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_10() { return getToken(claferParser.Surrogate_id_SYMB_10, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitReference(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_reference);
		try {
			setState(287);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((ReferenceContext)_localctx).result =  new clafer.Absyn.ReferenceEmpty(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				match(Surrogate_id_SYMB_9);
				setState(280);
				((ReferenceContext)_localctx).p_2_2 = exp23(0);
				 ((ReferenceContext)_localctx).result =  new clafer.Absyn.ReferenceSet(((ReferenceContext)_localctx).p_2_2.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(283);
				match(Surrogate_id_SYMB_10);
				setState(284);
				((ReferenceContext)_localctx).p_3_2 = exp23(0);
				 ((ReferenceContext)_localctx).result =  new clafer.Absyn.ReferenceBag(((ReferenceContext)_localctx).p_3_2.result); 
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

	public static class InitContext extends ParserRuleContext {
		public clafer.Absyn.Init result;
		public InitHowContext p_2_1;
		public ExpContext p_2_2;
		public InitHowContext initHow() {
			return getRuleContext(InitHowContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_init);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((InitContext)_localctx).result =  new clafer.Absyn.InitEmpty(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				((InitContext)_localctx).p_2_1 = initHow();
				setState(291);
				((InitContext)_localctx).p_2_2 = exp();
				 ((InitContext)_localctx).result =  new clafer.Absyn.InitSome(((InitContext)_localctx).p_2_1.result,((InitContext)_localctx).p_2_2.result); 
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

	public static class InitHowContext extends ParserRuleContext {
		public clafer.Absyn.InitHow result;
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(claferParser.Surrogate_id_SYMB_0, 0); }
		public TerminalNode Surrogate_id_SYMB_11() { return getToken(claferParser.Surrogate_id_SYMB_11, 0); }
		public InitHowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initHow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterInitHow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitInitHow(this);
		}
	}

	public final InitHowContext initHow() throws RecognitionException {
		InitHowContext _localctx = new InitHowContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_initHow);
		try {
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_0:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(Surrogate_id_SYMB_0);
				 ((InitHowContext)_localctx).result =  new clafer.Absyn.InitConstant(); 
				}
				break;
			case Surrogate_id_SYMB_11:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(Surrogate_id_SYMB_11);
				 ((InitHowContext)_localctx).result =  new clafer.Absyn.InitDefault(); 
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

	public static class GCardContext extends ParserRuleContext {
		public clafer.Absyn.GCard result;
		public NCardContext p_6_1;
		public TerminalNode Surrogate_id_SYMB_99() { return getToken(claferParser.Surrogate_id_SYMB_99, 0); }
		public TerminalNode Surrogate_id_SYMB_90() { return getToken(claferParser.Surrogate_id_SYMB_90, 0); }
		public TerminalNode Surrogate_id_SYMB_83() { return getToken(claferParser.Surrogate_id_SYMB_83, 0); }
		public TerminalNode Surrogate_id_SYMB_89() { return getToken(claferParser.Surrogate_id_SYMB_89, 0); }
		public NCardContext nCard() {
			return getRuleContext(NCardContext.class,0);
		}
		public GCardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gCard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterGCard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitGCard(this);
		}
	}

	public final GCardContext gCard() throws RecognitionException {
		GCardContext _localctx = new GCardContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_gCard);
		try {
			setState(314);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PosIdent:
				enterOuterAlt(_localctx, 1);
				{
				 ((GCardContext)_localctx).result =  new clafer.Absyn.GCardEmpty(); 
				}
				break;
			case Surrogate_id_SYMB_99:
				enterOuterAlt(_localctx, 2);
				{
				setState(303);
				match(Surrogate_id_SYMB_99);
				 ((GCardContext)_localctx).result =  new clafer.Absyn.GCardXor(); 
				}
				break;
			case Surrogate_id_SYMB_90:
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				match(Surrogate_id_SYMB_90);
				 ((GCardContext)_localctx).result =  new clafer.Absyn.GCardOr(); 
				}
				break;
			case Surrogate_id_SYMB_83:
				enterOuterAlt(_localctx, 4);
				{
				setState(307);
				match(Surrogate_id_SYMB_83);
				 ((GCardContext)_localctx).result =  new clafer.Absyn.GCardMux(); 
				}
				break;
			case Surrogate_id_SYMB_89:
				enterOuterAlt(_localctx, 5);
				{
				setState(309);
				match(Surrogate_id_SYMB_89);
				 ((GCardContext)_localctx).result =  new clafer.Absyn.GCardOpt(); 
				}
				break;
			case PosInteger:
				enterOuterAlt(_localctx, 6);
				{
				setState(311);
				((GCardContext)_localctx).p_6_1 = nCard();
				 ((GCardContext)_localctx).result =  new clafer.Absyn.GCardInterval(((GCardContext)_localctx).p_6_1.result); 
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

	public static class CardContext extends ParserRuleContext {
		public clafer.Absyn.Card result;
		public Token p_5_1;
		public NCardContext p_6_1;
		public TerminalNode Surrogate_id_SYMB_12() { return getToken(claferParser.Surrogate_id_SYMB_12, 0); }
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(claferParser.Surrogate_id_SYMB_13, 0); }
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(claferParser.Surrogate_id_SYMB_14, 0); }
		public TerminalNode PosInteger() { return getToken(claferParser.PosInteger, 0); }
		public NCardContext nCard() {
			return getRuleContext(NCardContext.class,0);
		}
		public CardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_card; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterCard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitCard(this);
		}
	}

	public final CardContext card() throws RecognitionException {
		CardContext _localctx = new CardContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_card);
		try {
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				 ((CardContext)_localctx).result =  new clafer.Absyn.CardEmpty(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				match(Surrogate_id_SYMB_12);
				 ((CardContext)_localctx).result =  new clafer.Absyn.CardLone(); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(319);
				match(Surrogate_id_SYMB_13);
				 ((CardContext)_localctx).result =  new clafer.Absyn.CardSome(); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(321);
				match(Surrogate_id_SYMB_14);
				 ((CardContext)_localctx).result =  new clafer.Absyn.CardAny(); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(323);
				((CardContext)_localctx).p_5_1 = match(PosInteger);
				 ((CardContext)_localctx).result =  new clafer.Absyn.CardNum(((CardContext)_localctx).p_5_1.getText()); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(325);
				((CardContext)_localctx).p_6_1 = nCard();
				 ((CardContext)_localctx).result =  new clafer.Absyn.CardInterval(((CardContext)_localctx).p_6_1.result); 
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

	public static class NCardContext extends ParserRuleContext {
		public clafer.Absyn.NCard result;
		public Token p_1_1;
		public ExIntegerContext p_1_3;
		public TerminalNode Surrogate_id_SYMB_15() { return getToken(claferParser.Surrogate_id_SYMB_15, 0); }
		public TerminalNode PosInteger() { return getToken(claferParser.PosInteger, 0); }
		public ExIntegerContext exInteger() {
			return getRuleContext(ExIntegerContext.class,0);
		}
		public NCardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nCard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterNCard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitNCard(this);
		}
	}

	public final NCardContext nCard() throws RecognitionException {
		NCardContext _localctx = new NCardContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_nCard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			((NCardContext)_localctx).p_1_1 = match(PosInteger);
			setState(331);
			match(Surrogate_id_SYMB_15);
			setState(332);
			((NCardContext)_localctx).p_1_3 = exInteger();
			 ((NCardContext)_localctx).result =  new clafer.Absyn.NNCard(((NCardContext)_localctx).p_1_1.getText(),((NCardContext)_localctx).p_1_3.result); 
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

	public static class ExIntegerContext extends ParserRuleContext {
		public clafer.Absyn.ExInteger result;
		public Token p_2_1;
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(claferParser.Surrogate_id_SYMB_14, 0); }
		public TerminalNode PosInteger() { return getToken(claferParser.PosInteger, 0); }
		public ExIntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exInteger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExInteger(this);
		}
	}

	public final ExIntegerContext exInteger() throws RecognitionException {
		ExIntegerContext _localctx = new ExIntegerContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_exInteger);
		try {
			setState(339);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_14:
				enterOuterAlt(_localctx, 1);
				{
				setState(335);
				match(Surrogate_id_SYMB_14);
				 ((ExIntegerContext)_localctx).result =  new clafer.Absyn.ExIntegerAst(); 
				}
				break;
			case PosInteger:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				((ExIntegerContext)_localctx).p_2_1 = match(PosInteger);
				 ((ExIntegerContext)_localctx).result =  new clafer.Absyn.ExIntegerNum(((ExIntegerContext)_localctx).p_2_1.getText()); 
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

	public static class NameContext extends ParserRuleContext {
		public clafer.Absyn.Name result;
		public ListModIdContext p_1_1;
		public ListModIdContext listModId() {
			return getRuleContext(ListModIdContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			((NameContext)_localctx).p_1_1 = listModId();
			 ((NameContext)_localctx).result =  new clafer.Absyn.Path(((NameContext)_localctx).p_1_1.result); 
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

	public static class ExpContext extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp1Context p_1_1;
		public TransArrowContext p_1_2;
		public ExpContext p_1_3;
		public Exp1Context p_2_1;
		public Exp1Context exp1() {
			return getRuleContext(Exp1Context.class,0);
		}
		public TransArrowContext transArrow() {
			return getRuleContext(TransArrowContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_exp);
		try {
			setState(352);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				((ExpContext)_localctx).p_1_1 = exp1();
				setState(345);
				((ExpContext)_localctx).p_1_2 = transArrow();
				setState(346);
				((ExpContext)_localctx).p_1_3 = exp();
				 ((ExpContext)_localctx).result =  new clafer.Absyn.TransitionExp(((ExpContext)_localctx).p_1_1.result,((ExpContext)_localctx).p_1_2.result,((ExpContext)_localctx).p_1_3.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				((ExpContext)_localctx).p_2_1 = exp1();
				 ((ExpContext)_localctx).result =  ((ExpContext)_localctx).p_2_1.result; 
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

	public static class Exp1Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public DeclContext p_1_3;
		public Exp1Context p_1_5;
		public DeclContext p_2_2;
		public Exp1Context p_2_4;
		public QuantContext p_3_1;
		public DeclContext p_3_3;
		public Exp1Context p_3_5;
		public QuantContext p_4_1;
		public DeclContext p_4_2;
		public Exp1Context p_4_4;
		public Exp1Context p_5_2;
		public Exp1Context p_5_4;
		public Exp1Context p_5_6;
		public VarBindingContext p_6_2;
		public Exp1Context p_6_4;
		public Exp2Context p_7_1;
		public TerminalNode Surrogate_id_SYMB_55() { return getToken(claferParser.Surrogate_id_SYMB_55, 0); }
		public TerminalNode Surrogate_id_SYMB_61() { return getToken(claferParser.Surrogate_id_SYMB_61, 0); }
		public TerminalNode Surrogate_id_SYMB_16() { return getToken(claferParser.Surrogate_id_SYMB_16, 0); }
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public List<Exp1Context> exp1() {
			return getRuleContexts(Exp1Context.class);
		}
		public Exp1Context exp1(int i) {
			return getRuleContext(Exp1Context.class,i);
		}
		public QuantContext quant() {
			return getRuleContext(QuantContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_71() { return getToken(claferParser.Surrogate_id_SYMB_71, 0); }
		public TerminalNode Surrogate_id_SYMB_96() { return getToken(claferParser.Surrogate_id_SYMB_96, 0); }
		public TerminalNode Surrogate_id_SYMB_62() { return getToken(claferParser.Surrogate_id_SYMB_62, 0); }
		public TerminalNode Surrogate_id_SYMB_75() { return getToken(claferParser.Surrogate_id_SYMB_75, 0); }
		public TerminalNode Surrogate_id_SYMB_72() { return getToken(claferParser.Surrogate_id_SYMB_72, 0); }
		public VarBindingContext varBinding() {
			return getRuleContext(VarBindingContext.class,0);
		}
		public Exp2Context exp2() {
			return getRuleContext(Exp2Context.class,0);
		}
		public Exp1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp1(this);
		}
	}

	public final Exp1Context exp1() throws RecognitionException {
		Exp1Context _localctx = new Exp1Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_exp1);
		try {
			setState(397);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				match(Surrogate_id_SYMB_55);
				setState(355);
				match(Surrogate_id_SYMB_61);
				setState(356);
				((Exp1Context)_localctx).p_1_3 = decl();
				setState(357);
				match(Surrogate_id_SYMB_16);
				setState(358);
				((Exp1Context)_localctx).p_1_5 = exp1();
				 ((Exp1Context)_localctx).result =  new clafer.Absyn.EDeclAllDisj(((Exp1Context)_localctx).p_1_3.result,((Exp1Context)_localctx).p_1_5.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(361);
				match(Surrogate_id_SYMB_55);
				setState(362);
				((Exp1Context)_localctx).p_2_2 = decl();
				setState(363);
				match(Surrogate_id_SYMB_16);
				setState(364);
				((Exp1Context)_localctx).p_2_4 = exp1();
				 ((Exp1Context)_localctx).result =  new clafer.Absyn.EDeclAll(((Exp1Context)_localctx).p_2_2.result,((Exp1Context)_localctx).p_2_4.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(367);
				((Exp1Context)_localctx).p_3_1 = quant();
				setState(368);
				match(Surrogate_id_SYMB_61);
				setState(369);
				((Exp1Context)_localctx).p_3_3 = decl();
				setState(370);
				match(Surrogate_id_SYMB_16);
				setState(371);
				((Exp1Context)_localctx).p_3_5 = exp1();
				 ((Exp1Context)_localctx).result =  new clafer.Absyn.EDeclQuantDisj(((Exp1Context)_localctx).p_3_1.result,((Exp1Context)_localctx).p_3_3.result,((Exp1Context)_localctx).p_3_5.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(374);
				((Exp1Context)_localctx).p_4_1 = quant();
				setState(375);
				((Exp1Context)_localctx).p_4_2 = decl();
				setState(376);
				match(Surrogate_id_SYMB_16);
				setState(377);
				((Exp1Context)_localctx).p_4_4 = exp1();
				 ((Exp1Context)_localctx).result =  new clafer.Absyn.EDeclQuant(((Exp1Context)_localctx).p_4_1.result,((Exp1Context)_localctx).p_4_2.result,((Exp1Context)_localctx).p_4_4.result); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(380);
				match(Surrogate_id_SYMB_71);
				setState(381);
				((Exp1Context)_localctx).p_5_2 = exp1();
				setState(382);
				match(Surrogate_id_SYMB_96);
				setState(383);
				((Exp1Context)_localctx).p_5_4 = exp1();
				setState(384);
				match(Surrogate_id_SYMB_62);
				setState(385);
				((Exp1Context)_localctx).p_5_6 = exp1();
				 ((Exp1Context)_localctx).result =  new clafer.Absyn.EImpliesElse(((Exp1Context)_localctx).p_5_2.result,((Exp1Context)_localctx).p_5_4.result,((Exp1Context)_localctx).p_5_6.result); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(388);
				match(Surrogate_id_SYMB_75);
				setState(389);
				((Exp1Context)_localctx).p_6_2 = varBinding();
				setState(390);
				match(Surrogate_id_SYMB_72);
				setState(391);
				((Exp1Context)_localctx).p_6_4 = exp1();
				 ((Exp1Context)_localctx).result =  new clafer.Absyn.LetExp(((Exp1Context)_localctx).p_6_2.result,((Exp1Context)_localctx).p_6_4.result); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(394);
				((Exp1Context)_localctx).p_7_1 = exp2();
				 ((Exp1Context)_localctx).result =  ((Exp1Context)_localctx).p_7_1.result; 
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

	public static class Exp2Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp3Context p_1_2;
		public PatternScopeContext p_1_3;
		public Exp3Context p_2_2;
		public PatternScopeContext p_2_3;
		public Exp3Context p_3_2;
		public PatternScopeContext p_3_3;
		public Exp3Context p_4_2;
		public PatternScopeContext p_4_3;
		public Exp3Context p_5_1;
		public Exp3Context p_5_4;
		public PatternScopeContext p_5_5;
		public Exp3Context p_6_1;
		public Exp3Context p_6_4;
		public PatternScopeContext p_6_5;
		public Exp3Context p_7_2;
		public Exp3Context p_8_2;
		public Exp3Context p_9_1;
		public TerminalNode Surrogate_id_SYMB_84() { return getToken(claferParser.Surrogate_id_SYMB_84, 0); }
		public List<Exp3Context> exp3() {
			return getRuleContexts(Exp3Context.class);
		}
		public Exp3Context exp3(int i) {
			return getRuleContext(Exp3Context.class,i);
		}
		public PatternScopeContext patternScope() {
			return getRuleContext(PatternScopeContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_94() { return getToken(claferParser.Surrogate_id_SYMB_94, 0); }
		public TerminalNode Surrogate_id_SYMB_76() { return getToken(claferParser.Surrogate_id_SYMB_76, 0); }
		public TerminalNode Surrogate_id_SYMB_56() { return getToken(claferParser.Surrogate_id_SYMB_56, 0); }
		public TerminalNode Surrogate_id_SYMB_82() { return getToken(claferParser.Surrogate_id_SYMB_82, 0); }
		public TerminalNode Surrogate_id_SYMB_91() { return getToken(claferParser.Surrogate_id_SYMB_91, 0); }
		public TerminalNode Surrogate_id_SYMB_69() { return getToken(claferParser.Surrogate_id_SYMB_69, 0); }
		public TerminalNode Surrogate_id_SYMB_74() { return getToken(claferParser.Surrogate_id_SYMB_74, 0); }
		public TerminalNode Surrogate_id_SYMB_66() { return getToken(claferParser.Surrogate_id_SYMB_66, 0); }
		public Exp2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp2(this);
		}
	}

	public final Exp2Context exp2() throws RecognitionException {
		Exp2Context _localctx = new Exp2Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_exp2);
		try {
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(399);
				match(Surrogate_id_SYMB_84);
				setState(400);
				((Exp2Context)_localctx).p_1_2 = exp3(0);
				setState(401);
				((Exp2Context)_localctx).p_1_3 = patternScope();
				 ((Exp2Context)_localctx).result =  new clafer.Absyn.TmpPatNever(((Exp2Context)_localctx).p_1_2.result,((Exp2Context)_localctx).p_1_3.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				match(Surrogate_id_SYMB_94);
				setState(405);
				((Exp2Context)_localctx).p_2_2 = exp3(0);
				setState(406);
				((Exp2Context)_localctx).p_2_3 = patternScope();
				 ((Exp2Context)_localctx).result =  new clafer.Absyn.TmpPatSometime(((Exp2Context)_localctx).p_2_2.result,((Exp2Context)_localctx).p_2_3.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(409);
				match(Surrogate_id_SYMB_76);
				setState(410);
				((Exp2Context)_localctx).p_3_2 = exp3(0);
				setState(411);
				((Exp2Context)_localctx).p_3_3 = patternScope();
				 ((Exp2Context)_localctx).result =  new clafer.Absyn.TmpPatLessOrOnce(((Exp2Context)_localctx).p_3_2.result,((Exp2Context)_localctx).p_3_3.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(414);
				match(Surrogate_id_SYMB_56);
				setState(415);
				((Exp2Context)_localctx).p_4_2 = exp3(0);
				setState(416);
				((Exp2Context)_localctx).p_4_3 = patternScope();
				 ((Exp2Context)_localctx).result =  new clafer.Absyn.TmpPatAlways(((Exp2Context)_localctx).p_4_2.result,((Exp2Context)_localctx).p_4_3.result); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(419);
				((Exp2Context)_localctx).p_5_1 = exp3(0);
				setState(420);
				match(Surrogate_id_SYMB_82);
				setState(421);
				match(Surrogate_id_SYMB_91);
				setState(422);
				((Exp2Context)_localctx).p_5_4 = exp3(0);
				setState(423);
				((Exp2Context)_localctx).p_5_5 = patternScope();
				 ((Exp2Context)_localctx).result =  new clafer.Absyn.TmpPatPrecede(((Exp2Context)_localctx).p_5_1.result,((Exp2Context)_localctx).p_5_4.result,((Exp2Context)_localctx).p_5_5.result); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(426);
				((Exp2Context)_localctx).p_6_1 = exp3(0);
				setState(427);
				match(Surrogate_id_SYMB_82);
				setState(428);
				match(Surrogate_id_SYMB_69);
				setState(429);
				((Exp2Context)_localctx).p_6_4 = exp3(0);
				setState(430);
				((Exp2Context)_localctx).p_6_5 = patternScope();
				 ((Exp2Context)_localctx).result =  new clafer.Absyn.TmpPatFollow(((Exp2Context)_localctx).p_6_1.result,((Exp2Context)_localctx).p_6_4.result,((Exp2Context)_localctx).p_6_5.result); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(433);
				match(Surrogate_id_SYMB_74);
				setState(434);
				((Exp2Context)_localctx).p_7_2 = exp3(0);
				 ((Exp2Context)_localctx).result =  new clafer.Absyn.TmpInitially(((Exp2Context)_localctx).p_7_2.result); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(437);
				match(Surrogate_id_SYMB_66);
				setState(438);
				((Exp2Context)_localctx).p_8_2 = exp3(0);
				 ((Exp2Context)_localctx).result =  new clafer.Absyn.TmpFinally(((Exp2Context)_localctx).p_8_2.result); 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(441);
				((Exp2Context)_localctx).p_9_1 = exp3(0);
				 ((Exp2Context)_localctx).result =  ((Exp2Context)_localctx).p_9_1.result; 
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

	public static class Exp3Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp3Context p_1_1;
		public Exp4Context p_2_1;
		public Exp4Context p_1_3;
		public Exp4Context exp4() {
			return getRuleContext(Exp4Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_17() { return getToken(claferParser.Surrogate_id_SYMB_17, 0); }
		public Exp3Context exp3() {
			return getRuleContext(Exp3Context.class,0);
		}
		public Exp3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp3(this);
		}
	}

	public final Exp3Context exp3() throws RecognitionException {
		return exp3(0);
	}

	private Exp3Context exp3(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp3Context _localctx = new Exp3Context(_ctx, _parentState);
		Exp3Context _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_exp3, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(447);
			((Exp3Context)_localctx).p_2_1 = exp4(0);
			 ((Exp3Context)_localctx).result =  ((Exp3Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(457);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp3Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp3);
					setState(450);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(451);
					match(Surrogate_id_SYMB_17);
					setState(452);
					((Exp3Context)_localctx).p_1_3 = exp4(0);
					 ((Exp3Context)_localctx).result =  new clafer.Absyn.EIff(((Exp3Context)_localctx).p_1_1.result,((Exp3Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(459);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class Exp4Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp4Context p_1_1;
		public Exp5Context p_2_1;
		public Exp5Context p_1_3;
		public Exp5Context exp5() {
			return getRuleContext(Exp5Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_18() { return getToken(claferParser.Surrogate_id_SYMB_18, 0); }
		public Exp4Context exp4() {
			return getRuleContext(Exp4Context.class,0);
		}
		public Exp4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp4(this);
		}
	}

	public final Exp4Context exp4() throws RecognitionException {
		return exp4(0);
	}

	private Exp4Context exp4(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp4Context _localctx = new Exp4Context(_ctx, _parentState);
		Exp4Context _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_exp4, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(461);
			((Exp4Context)_localctx).p_2_1 = exp5(0);
			 ((Exp4Context)_localctx).result =  ((Exp4Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(471);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp4Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp4);
					setState(464);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(465);
					match(Surrogate_id_SYMB_18);
					setState(466);
					((Exp4Context)_localctx).p_1_3 = exp5(0);
					 ((Exp4Context)_localctx).result =  new clafer.Absyn.EImplies(((Exp4Context)_localctx).p_1_1.result,((Exp4Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(473);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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

	public static class Exp5Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp5Context p_1_1;
		public Exp6Context p_2_1;
		public Exp6Context p_1_3;
		public Exp6Context exp6() {
			return getRuleContext(Exp6Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_19() { return getToken(claferParser.Surrogate_id_SYMB_19, 0); }
		public Exp5Context exp5() {
			return getRuleContext(Exp5Context.class,0);
		}
		public Exp5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp5; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp5(this);
		}
	}

	public final Exp5Context exp5() throws RecognitionException {
		return exp5(0);
	}

	private Exp5Context exp5(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp5Context _localctx = new Exp5Context(_ctx, _parentState);
		Exp5Context _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_exp5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(475);
			((Exp5Context)_localctx).p_2_1 = exp6(0);
			 ((Exp5Context)_localctx).result =  ((Exp5Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(485);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp5Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp5);
					setState(478);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(479);
					match(Surrogate_id_SYMB_19);
					setState(480);
					((Exp5Context)_localctx).p_1_3 = exp6(0);
					 ((Exp5Context)_localctx).result =  new clafer.Absyn.EOr(((Exp5Context)_localctx).p_1_1.result,((Exp5Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(487);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class Exp6Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp6Context p_1_1;
		public Exp7Context p_2_1;
		public Exp7Context p_1_3;
		public Exp7Context exp7() {
			return getRuleContext(Exp7Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_99() { return getToken(claferParser.Surrogate_id_SYMB_99, 0); }
		public Exp6Context exp6() {
			return getRuleContext(Exp6Context.class,0);
		}
		public Exp6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp6; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp6(this);
		}
	}

	public final Exp6Context exp6() throws RecognitionException {
		return exp6(0);
	}

	private Exp6Context exp6(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp6Context _localctx = new Exp6Context(_ctx, _parentState);
		Exp6Context _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_exp6, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(489);
			((Exp6Context)_localctx).p_2_1 = exp7(0);
			 ((Exp6Context)_localctx).result =  ((Exp6Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(499);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp6Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp6);
					setState(492);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(493);
					match(Surrogate_id_SYMB_99);
					setState(494);
					((Exp6Context)_localctx).p_1_3 = exp7(0);
					 ((Exp6Context)_localctx).result =  new clafer.Absyn.EXor(((Exp6Context)_localctx).p_1_1.result,((Exp6Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(501);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class Exp7Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp7Context p_1_1;
		public Exp8Context p_2_1;
		public Exp8Context p_1_3;
		public Exp8Context exp8() {
			return getRuleContext(Exp8Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_20() { return getToken(claferParser.Surrogate_id_SYMB_20, 0); }
		public Exp7Context exp7() {
			return getRuleContext(Exp7Context.class,0);
		}
		public Exp7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp7; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp7(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp7(this);
		}
	}

	public final Exp7Context exp7() throws RecognitionException {
		return exp7(0);
	}

	private Exp7Context exp7(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp7Context _localctx = new Exp7Context(_ctx, _parentState);
		Exp7Context _prevctx = _localctx;
		int _startState = 64;
		enterRecursionRule(_localctx, 64, RULE_exp7, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(503);
			((Exp7Context)_localctx).p_2_1 = exp8(0);
			 ((Exp7Context)_localctx).result =  ((Exp7Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(513);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp7Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp7);
					setState(506);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(507);
					match(Surrogate_id_SYMB_20);
					setState(508);
					((Exp7Context)_localctx).p_1_3 = exp8(0);
					 ((Exp7Context)_localctx).result =  new clafer.Absyn.EAnd(((Exp7Context)_localctx).p_1_1.result,((Exp7Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(515);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class Exp8Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp8Context p_1_1;
		public Exp8Context p_2_1;
		public Exp9Context p_3_1;
		public Exp9Context p_1_3;
		public Exp9Context p_2_3;
		public Exp9Context exp9() {
			return getRuleContext(Exp9Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_50() { return getToken(claferParser.Surrogate_id_SYMB_50, 0); }
		public Exp8Context exp8() {
			return getRuleContext(Exp8Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_97() { return getToken(claferParser.Surrogate_id_SYMB_97, 0); }
		public Exp8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp8; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp8(this);
		}
	}

	public final Exp8Context exp8() throws RecognitionException {
		return exp8(0);
	}

	private Exp8Context exp8(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp8Context _localctx = new Exp8Context(_ctx, _parentState);
		Exp8Context _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_exp8, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(517);
			((Exp8Context)_localctx).p_3_1 = exp9(0);
			 ((Exp8Context)_localctx).result =  ((Exp8Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(532);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(530);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new Exp8Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp8);
						setState(520);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(521);
						match(Surrogate_id_SYMB_50);
						setState(522);
						((Exp8Context)_localctx).p_1_3 = exp9(0);
						 ((Exp8Context)_localctx).result =  new clafer.Absyn.LtlU(((Exp8Context)_localctx).p_1_1.result,((Exp8Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Exp8Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp8);
						setState(525);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(526);
						match(Surrogate_id_SYMB_97);
						setState(527);
						((Exp8Context)_localctx).p_2_3 = exp9(0);
						 ((Exp8Context)_localctx).result =  new clafer.Absyn.TmpUntil(((Exp8Context)_localctx).p_2_1.result,((Exp8Context)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(534);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class Exp9Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp9Context p_1_1;
		public Exp9Context p_2_1;
		public Exp10Context p_3_1;
		public Exp10Context p_1_3;
		public Exp10Context p_2_3;
		public Exp10Context exp10() {
			return getRuleContext(Exp10Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_51() { return getToken(claferParser.Surrogate_id_SYMB_51, 0); }
		public Exp9Context exp9() {
			return getRuleContext(Exp9Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_98() { return getToken(claferParser.Surrogate_id_SYMB_98, 0); }
		public Exp9Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp9; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp9(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp9(this);
		}
	}

	public final Exp9Context exp9() throws RecognitionException {
		return exp9(0);
	}

	private Exp9Context exp9(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp9Context _localctx = new Exp9Context(_ctx, _parentState);
		Exp9Context _prevctx = _localctx;
		int _startState = 68;
		enterRecursionRule(_localctx, 68, RULE_exp9, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(536);
			((Exp9Context)_localctx).p_3_1 = exp10();
			 ((Exp9Context)_localctx).result =  ((Exp9Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(551);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(549);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new Exp9Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp9);
						setState(539);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(540);
						match(Surrogate_id_SYMB_51);
						setState(541);
						((Exp9Context)_localctx).p_1_3 = exp10();
						 ((Exp9Context)_localctx).result =  new clafer.Absyn.LtlW(((Exp9Context)_localctx).p_1_1.result,((Exp9Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Exp9Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp9);
						setState(544);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(545);
						match(Surrogate_id_SYMB_98);
						setState(546);
						((Exp9Context)_localctx).p_2_3 = exp10();
						 ((Exp9Context)_localctx).result =  new clafer.Absyn.TmpWUntil(((Exp9Context)_localctx).p_2_1.result,((Exp9Context)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(553);
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

	public static class Exp10Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp10Context p_1_2;
		public Exp10Context p_2_2;
		public Exp10Context p_3_2;
		public Exp10Context p_4_2;
		public Exp10Context p_5_2;
		public Exp10Context p_6_2;
		public Exp11Context p_7_1;
		public TerminalNode Surrogate_id_SYMB_48() { return getToken(claferParser.Surrogate_id_SYMB_48, 0); }
		public Exp10Context exp10() {
			return getRuleContext(Exp10Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_64() { return getToken(claferParser.Surrogate_id_SYMB_64, 0); }
		public TerminalNode Surrogate_id_SYMB_49() { return getToken(claferParser.Surrogate_id_SYMB_49, 0); }
		public TerminalNode Surrogate_id_SYMB_70() { return getToken(claferParser.Surrogate_id_SYMB_70, 0); }
		public TerminalNode Surrogate_id_SYMB_52() { return getToken(claferParser.Surrogate_id_SYMB_52, 0); }
		public TerminalNode Surrogate_id_SYMB_85() { return getToken(claferParser.Surrogate_id_SYMB_85, 0); }
		public Exp11Context exp11() {
			return getRuleContext(Exp11Context.class,0);
		}
		public Exp10Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp10; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp10(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp10(this);
		}
	}

	public final Exp10Context exp10() throws RecognitionException {
		Exp10Context _localctx = new Exp10Context(_ctx, getState());
		enterRule(_localctx, 70, RULE_exp10);
		try {
			setState(581);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_48:
				enterOuterAlt(_localctx, 1);
				{
				setState(554);
				match(Surrogate_id_SYMB_48);
				setState(555);
				((Exp10Context)_localctx).p_1_2 = exp10();
				 ((Exp10Context)_localctx).result =  new clafer.Absyn.LtlF(((Exp10Context)_localctx).p_1_2.result); 
				}
				break;
			case Surrogate_id_SYMB_64:
				enterOuterAlt(_localctx, 2);
				{
				setState(558);
				match(Surrogate_id_SYMB_64);
				setState(559);
				((Exp10Context)_localctx).p_2_2 = exp10();
				 ((Exp10Context)_localctx).result =  new clafer.Absyn.TmpEventually(((Exp10Context)_localctx).p_2_2.result); 
				}
				break;
			case Surrogate_id_SYMB_49:
				enterOuterAlt(_localctx, 3);
				{
				setState(562);
				match(Surrogate_id_SYMB_49);
				setState(563);
				((Exp10Context)_localctx).p_3_2 = exp10();
				 ((Exp10Context)_localctx).result =  new clafer.Absyn.LtlG(((Exp10Context)_localctx).p_3_2.result); 
				}
				break;
			case Surrogate_id_SYMB_70:
				enterOuterAlt(_localctx, 4);
				{
				setState(566);
				match(Surrogate_id_SYMB_70);
				setState(567);
				((Exp10Context)_localctx).p_4_2 = exp10();
				 ((Exp10Context)_localctx).result =  new clafer.Absyn.TmpGlobally(((Exp10Context)_localctx).p_4_2.result); 
				}
				break;
			case Surrogate_id_SYMB_52:
				enterOuterAlt(_localctx, 5);
				{
				setState(570);
				match(Surrogate_id_SYMB_52);
				setState(571);
				((Exp10Context)_localctx).p_5_2 = exp10();
				 ((Exp10Context)_localctx).result =  new clafer.Absyn.LtlX(((Exp10Context)_localctx).p_5_2.result); 
				}
				break;
			case Surrogate_id_SYMB_85:
				enterOuterAlt(_localctx, 6);
				{
				setState(574);
				match(Surrogate_id_SYMB_85);
				setState(575);
				((Exp10Context)_localctx).p_6_2 = exp10();
				 ((Exp10Context)_localctx).result =  new clafer.Absyn.TmpNext(((Exp10Context)_localctx).p_6_2.result); 
				}
				break;
			case Surrogate_id_SYMB_21:
			case Surrogate_id_SYMB_27:
			case Surrogate_id_SYMB_30:
			case Surrogate_id_SYMB_46:
			case Surrogate_id_SYMB_77:
			case Surrogate_id_SYMB_78:
			case Surrogate_id_SYMB_80:
			case Surrogate_id_SYMB_86:
			case Surrogate_id_SYMB_87:
			case Surrogate_id_SYMB_88:
			case Surrogate_id_SYMB_92:
			case Surrogate_id_SYMB_93:
			case Surrogate_id_SYMB_95:
			case PosInteger:
			case PosDouble:
			case PosReal:
			case PosString:
			case PosIdent:
				enterOuterAlt(_localctx, 7);
				{
				setState(578);
				((Exp10Context)_localctx).p_7_1 = exp11();
				 ((Exp10Context)_localctx).result =  ((Exp10Context)_localctx).p_7_1.result; 
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

	public static class Exp11Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp11Context p_1_2;
		public Exp12Context p_2_1;
		public TerminalNode Surrogate_id_SYMB_21() { return getToken(claferParser.Surrogate_id_SYMB_21, 0); }
		public Exp11Context exp11() {
			return getRuleContext(Exp11Context.class,0);
		}
		public Exp12Context exp12() {
			return getRuleContext(Exp12Context.class,0);
		}
		public Exp11Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp11; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp11(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp11(this);
		}
	}

	public final Exp11Context exp11() throws RecognitionException {
		Exp11Context _localctx = new Exp11Context(_ctx, getState());
		enterRule(_localctx, 72, RULE_exp11);
		try {
			setState(590);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_21:
				enterOuterAlt(_localctx, 1);
				{
				setState(583);
				match(Surrogate_id_SYMB_21);
				setState(584);
				((Exp11Context)_localctx).p_1_2 = exp11();
				 ((Exp11Context)_localctx).result =  new clafer.Absyn.ENeg(((Exp11Context)_localctx).p_1_2.result); 
				}
				break;
			case Surrogate_id_SYMB_27:
			case Surrogate_id_SYMB_30:
			case Surrogate_id_SYMB_46:
			case Surrogate_id_SYMB_77:
			case Surrogate_id_SYMB_78:
			case Surrogate_id_SYMB_80:
			case Surrogate_id_SYMB_86:
			case Surrogate_id_SYMB_87:
			case Surrogate_id_SYMB_88:
			case Surrogate_id_SYMB_92:
			case Surrogate_id_SYMB_93:
			case Surrogate_id_SYMB_95:
			case PosInteger:
			case PosDouble:
			case PosReal:
			case PosString:
			case PosIdent:
				enterOuterAlt(_localctx, 2);
				{
				setState(587);
				((Exp11Context)_localctx).p_2_1 = exp12();
				 ((Exp11Context)_localctx).result =  ((Exp11Context)_localctx).p_2_1.result; 
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

	public static class Exp15Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp15Context p_1_1;
		public Exp15Context p_2_1;
		public Exp15Context p_3_1;
		public Exp15Context p_4_1;
		public Exp15Context p_5_1;
		public Exp15Context p_6_1;
		public Exp15Context p_7_1;
		public Exp15Context p_8_1;
		public Exp16Context p_9_1;
		public Exp16Context p_1_3;
		public Exp16Context p_2_3;
		public Exp16Context p_3_3;
		public Exp16Context p_4_3;
		public Exp16Context p_5_3;
		public Exp16Context p_6_3;
		public Exp16Context p_7_3;
		public Exp16Context p_8_4;
		public Exp16Context exp16() {
			return getRuleContext(Exp16Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_22() { return getToken(claferParser.Surrogate_id_SYMB_22, 0); }
		public Exp15Context exp15() {
			return getRuleContext(Exp15Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_23() { return getToken(claferParser.Surrogate_id_SYMB_23, 0); }
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(claferParser.Surrogate_id_SYMB_0, 0); }
		public TerminalNode Surrogate_id_SYMB_24() { return getToken(claferParser.Surrogate_id_SYMB_24, 0); }
		public TerminalNode Surrogate_id_SYMB_25() { return getToken(claferParser.Surrogate_id_SYMB_25, 0); }
		public TerminalNode Surrogate_id_SYMB_26() { return getToken(claferParser.Surrogate_id_SYMB_26, 0); }
		public TerminalNode Surrogate_id_SYMB_72() { return getToken(claferParser.Surrogate_id_SYMB_72, 0); }
		public TerminalNode Surrogate_id_SYMB_87() { return getToken(claferParser.Surrogate_id_SYMB_87, 0); }
		public Exp15Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp15; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp15(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp15(this);
		}
	}

	public final Exp15Context exp15() throws RecognitionException {
		return exp15(0);
	}

	private Exp15Context exp15(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp15Context _localctx = new Exp15Context(_ctx, _parentState);
		Exp15Context _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_exp15, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(593);
			((Exp15Context)_localctx).p_9_1 = exp16();
			 ((Exp15Context)_localctx).result =  ((Exp15Context)_localctx).p_9_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(639);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(637);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new Exp15Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp15);
						setState(596);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(597);
						match(Surrogate_id_SYMB_22);
						setState(598);
						((Exp15Context)_localctx).p_1_3 = exp16();
						 ((Exp15Context)_localctx).result =  new clafer.Absyn.ELt(((Exp15Context)_localctx).p_1_1.result,((Exp15Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Exp15Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp15);
						setState(601);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(602);
						match(Surrogate_id_SYMB_23);
						setState(603);
						((Exp15Context)_localctx).p_2_3 = exp16();
						 ((Exp15Context)_localctx).result =  new clafer.Absyn.EGt(((Exp15Context)_localctx).p_2_1.result,((Exp15Context)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new Exp15Context(_parentctx, _parentState);
						_localctx.p_3_1 = _prevctx;
						_localctx.p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp15);
						setState(606);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(607);
						match(Surrogate_id_SYMB_0);
						setState(608);
						((Exp15Context)_localctx).p_3_3 = exp16();
						 ((Exp15Context)_localctx).result =  new clafer.Absyn.EEq(((Exp15Context)_localctx).p_3_1.result,((Exp15Context)_localctx).p_3_3.result); 
						}
						break;
					case 4:
						{
						_localctx = new Exp15Context(_parentctx, _parentState);
						_localctx.p_4_1 = _prevctx;
						_localctx.p_4_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp15);
						setState(611);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(612);
						match(Surrogate_id_SYMB_24);
						setState(613);
						((Exp15Context)_localctx).p_4_3 = exp16();
						 ((Exp15Context)_localctx).result =  new clafer.Absyn.ELte(((Exp15Context)_localctx).p_4_1.result,((Exp15Context)_localctx).p_4_3.result); 
						}
						break;
					case 5:
						{
						_localctx = new Exp15Context(_parentctx, _parentState);
						_localctx.p_5_1 = _prevctx;
						_localctx.p_5_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp15);
						setState(616);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(617);
						match(Surrogate_id_SYMB_25);
						setState(618);
						((Exp15Context)_localctx).p_5_3 = exp16();
						 ((Exp15Context)_localctx).result =  new clafer.Absyn.EGte(((Exp15Context)_localctx).p_5_1.result,((Exp15Context)_localctx).p_5_3.result); 
						}
						break;
					case 6:
						{
						_localctx = new Exp15Context(_parentctx, _parentState);
						_localctx.p_6_1 = _prevctx;
						_localctx.p_6_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp15);
						setState(621);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(622);
						match(Surrogate_id_SYMB_26);
						setState(623);
						((Exp15Context)_localctx).p_6_3 = exp16();
						 ((Exp15Context)_localctx).result =  new clafer.Absyn.ENeq(((Exp15Context)_localctx).p_6_1.result,((Exp15Context)_localctx).p_6_3.result); 
						}
						break;
					case 7:
						{
						_localctx = new Exp15Context(_parentctx, _parentState);
						_localctx.p_7_1 = _prevctx;
						_localctx.p_7_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp15);
						setState(626);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(627);
						match(Surrogate_id_SYMB_72);
						setState(628);
						((Exp15Context)_localctx).p_7_3 = exp16();
						 ((Exp15Context)_localctx).result =  new clafer.Absyn.EIn(((Exp15Context)_localctx).p_7_1.result,((Exp15Context)_localctx).p_7_3.result); 
						}
						break;
					case 8:
						{
						_localctx = new Exp15Context(_parentctx, _parentState);
						_localctx.p_8_1 = _prevctx;
						_localctx.p_8_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp15);
						setState(631);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(632);
						match(Surrogate_id_SYMB_87);
						setState(633);
						match(Surrogate_id_SYMB_72);
						setState(634);
						((Exp15Context)_localctx).p_8_4 = exp16();
						 ((Exp15Context)_localctx).result =  new clafer.Absyn.ENin(((Exp15Context)_localctx).p_8_1.result,((Exp15Context)_localctx).p_8_4.result); 
						}
						break;
					}
					} 
				}
				setState(641);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public static class Exp16Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public QuantContext p_1_1;
		public Exp20Context p_1_2;
		public Exp17Context p_2_1;
		public QuantContext quant() {
			return getRuleContext(QuantContext.class,0);
		}
		public Exp20Context exp20() {
			return getRuleContext(Exp20Context.class,0);
		}
		public Exp17Context exp17() {
			return getRuleContext(Exp17Context.class,0);
		}
		public Exp16Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp16; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp16(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp16(this);
		}
	}

	public final Exp16Context exp16() throws RecognitionException {
		Exp16Context _localctx = new Exp16Context(_ctx, getState());
		enterRule(_localctx, 76, RULE_exp16);
		try {
			setState(649);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_77:
			case Surrogate_id_SYMB_86:
			case Surrogate_id_SYMB_87:
			case Surrogate_id_SYMB_88:
			case Surrogate_id_SYMB_93:
				enterOuterAlt(_localctx, 1);
				{
				setState(642);
				((Exp16Context)_localctx).p_1_1 = quant();
				setState(643);
				((Exp16Context)_localctx).p_1_2 = exp20();
				 ((Exp16Context)_localctx).result =  new clafer.Absyn.EQuantExp(((Exp16Context)_localctx).p_1_1.result,((Exp16Context)_localctx).p_1_2.result); 
				}
				break;
			case Surrogate_id_SYMB_27:
			case Surrogate_id_SYMB_30:
			case Surrogate_id_SYMB_46:
			case Surrogate_id_SYMB_78:
			case Surrogate_id_SYMB_80:
			case Surrogate_id_SYMB_92:
			case Surrogate_id_SYMB_95:
			case PosInteger:
			case PosDouble:
			case PosReal:
			case PosString:
			case PosIdent:
				enterOuterAlt(_localctx, 2);
				{
				setState(646);
				((Exp16Context)_localctx).p_2_1 = exp17(0);
				 ((Exp16Context)_localctx).result =  ((Exp16Context)_localctx).p_2_1.result; 
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

	public static class Exp17Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp17Context p_1_1;
		public Exp17Context p_2_1;
		public Exp18Context p_3_1;
		public Exp18Context p_1_3;
		public Exp18Context p_2_3;
		public Exp18Context exp18() {
			return getRuleContext(Exp18Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_13() { return getToken(claferParser.Surrogate_id_SYMB_13, 0); }
		public Exp17Context exp17() {
			return getRuleContext(Exp17Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_27() { return getToken(claferParser.Surrogate_id_SYMB_27, 0); }
		public Exp17Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp17; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp17(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp17(this);
		}
	}

	public final Exp17Context exp17() throws RecognitionException {
		return exp17(0);
	}

	private Exp17Context exp17(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp17Context _localctx = new Exp17Context(_ctx, _parentState);
		Exp17Context _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_exp17, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(652);
			((Exp17Context)_localctx).p_3_1 = exp18(0);
			 ((Exp17Context)_localctx).result =  ((Exp17Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(667);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(665);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new Exp17Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp17);
						setState(655);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(656);
						match(Surrogate_id_SYMB_13);
						setState(657);
						((Exp17Context)_localctx).p_1_3 = exp18(0);
						 ((Exp17Context)_localctx).result =  new clafer.Absyn.EAdd(((Exp17Context)_localctx).p_1_1.result,((Exp17Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Exp17Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp17);
						setState(660);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(661);
						match(Surrogate_id_SYMB_27);
						setState(662);
						((Exp17Context)_localctx).p_2_3 = exp18(0);
						 ((Exp17Context)_localctx).result =  new clafer.Absyn.ESub(((Exp17Context)_localctx).p_2_1.result,((Exp17Context)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(669);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class Exp18Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp18Context p_1_1;
		public Exp18Context p_2_1;
		public Exp18Context p_3_1;
		public Exp19Context p_4_1;
		public Exp19Context p_1_3;
		public Exp19Context p_2_3;
		public Exp19Context p_3_3;
		public Exp19Context exp19() {
			return getRuleContext(Exp19Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_14() { return getToken(claferParser.Surrogate_id_SYMB_14, 0); }
		public Exp18Context exp18() {
			return getRuleContext(Exp18Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_28() { return getToken(claferParser.Surrogate_id_SYMB_28, 0); }
		public TerminalNode Surrogate_id_SYMB_29() { return getToken(claferParser.Surrogate_id_SYMB_29, 0); }
		public Exp18Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp18; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp18(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp18(this);
		}
	}

	public final Exp18Context exp18() throws RecognitionException {
		return exp18(0);
	}

	private Exp18Context exp18(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp18Context _localctx = new Exp18Context(_ctx, _parentState);
		Exp18Context _prevctx = _localctx;
		int _startState = 80;
		enterRecursionRule(_localctx, 80, RULE_exp18, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(671);
			((Exp18Context)_localctx).p_4_1 = exp19();
			 ((Exp18Context)_localctx).result =  ((Exp18Context)_localctx).p_4_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(691);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(689);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new Exp18Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp18);
						setState(674);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(675);
						match(Surrogate_id_SYMB_14);
						setState(676);
						((Exp18Context)_localctx).p_1_3 = exp19();
						 ((Exp18Context)_localctx).result =  new clafer.Absyn.EMul(((Exp18Context)_localctx).p_1_1.result,((Exp18Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Exp18Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp18);
						setState(679);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(680);
						match(Surrogate_id_SYMB_28);
						setState(681);
						((Exp18Context)_localctx).p_2_3 = exp19();
						 ((Exp18Context)_localctx).result =  new clafer.Absyn.EDiv(((Exp18Context)_localctx).p_2_1.result,((Exp18Context)_localctx).p_2_3.result); 
						}
						break;
					case 3:
						{
						_localctx = new Exp18Context(_parentctx, _parentState);
						_localctx.p_3_1 = _prevctx;
						_localctx.p_3_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp18);
						setState(684);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(685);
						match(Surrogate_id_SYMB_29);
						setState(686);
						((Exp18Context)_localctx).p_3_3 = exp19();
						 ((Exp18Context)_localctx).result =  new clafer.Absyn.ERem(((Exp18Context)_localctx).p_3_1.result,((Exp18Context)_localctx).p_3_3.result); 
						}
						break;
					}
					} 
				}
				setState(693);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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

	public static class Exp19Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp20Context p_1_2;
		public Exp20Context p_2_2;
		public Exp20Context p_3_1;
		public TerminalNode Surrogate_id_SYMB_78() { return getToken(claferParser.Surrogate_id_SYMB_78, 0); }
		public Exp20Context exp20() {
			return getRuleContext(Exp20Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_80() { return getToken(claferParser.Surrogate_id_SYMB_80, 0); }
		public Exp19Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp19; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp19(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp19(this);
		}
	}

	public final Exp19Context exp19() throws RecognitionException {
		Exp19Context _localctx = new Exp19Context(_ctx, getState());
		enterRule(_localctx, 82, RULE_exp19);
		try {
			setState(705);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_78:
				enterOuterAlt(_localctx, 1);
				{
				setState(694);
				match(Surrogate_id_SYMB_78);
				setState(695);
				((Exp19Context)_localctx).p_1_2 = exp20();
				 ((Exp19Context)_localctx).result =  new clafer.Absyn.EGMax(((Exp19Context)_localctx).p_1_2.result); 
				}
				break;
			case Surrogate_id_SYMB_80:
				enterOuterAlt(_localctx, 2);
				{
				setState(698);
				match(Surrogate_id_SYMB_80);
				setState(699);
				((Exp19Context)_localctx).p_2_2 = exp20();
				 ((Exp19Context)_localctx).result =  new clafer.Absyn.EGMin(((Exp19Context)_localctx).p_2_2.result); 
				}
				break;
			case Surrogate_id_SYMB_27:
			case Surrogate_id_SYMB_30:
			case Surrogate_id_SYMB_46:
			case Surrogate_id_SYMB_92:
			case Surrogate_id_SYMB_95:
			case PosInteger:
			case PosDouble:
			case PosReal:
			case PosString:
			case PosIdent:
				enterOuterAlt(_localctx, 3);
				{
				setState(702);
				((Exp19Context)_localctx).p_3_1 = exp20();
				 ((Exp19Context)_localctx).result =  ((Exp19Context)_localctx).p_3_1.result; 
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

	public static class Exp20Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp21Context p_1_2;
		public Exp21Context p_2_2;
		public Exp21Context p_3_2;
		public Exp21Context p_4_2;
		public Exp21Context p_5_1;
		public TerminalNode Surrogate_id_SYMB_95() { return getToken(claferParser.Surrogate_id_SYMB_95, 0); }
		public Exp21Context exp21() {
			return getRuleContext(Exp21Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_92() { return getToken(claferParser.Surrogate_id_SYMB_92, 0); }
		public TerminalNode Surrogate_id_SYMB_30() { return getToken(claferParser.Surrogate_id_SYMB_30, 0); }
		public TerminalNode Surrogate_id_SYMB_27() { return getToken(claferParser.Surrogate_id_SYMB_27, 0); }
		public Exp20Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp20; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp20(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp20(this);
		}
	}

	public final Exp20Context exp20() throws RecognitionException {
		Exp20Context _localctx = new Exp20Context(_ctx, getState());
		enterRule(_localctx, 84, RULE_exp20);
		try {
			setState(726);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_95:
				enterOuterAlt(_localctx, 1);
				{
				setState(707);
				match(Surrogate_id_SYMB_95);
				setState(708);
				((Exp20Context)_localctx).p_1_2 = exp21(0);
				 ((Exp20Context)_localctx).result =  new clafer.Absyn.ESum(((Exp20Context)_localctx).p_1_2.result); 
				}
				break;
			case Surrogate_id_SYMB_92:
				enterOuterAlt(_localctx, 2);
				{
				setState(711);
				match(Surrogate_id_SYMB_92);
				setState(712);
				((Exp20Context)_localctx).p_2_2 = exp21(0);
				 ((Exp20Context)_localctx).result =  new clafer.Absyn.EProd(((Exp20Context)_localctx).p_2_2.result); 
				}
				break;
			case Surrogate_id_SYMB_30:
				enterOuterAlt(_localctx, 3);
				{
				setState(715);
				match(Surrogate_id_SYMB_30);
				setState(716);
				((Exp20Context)_localctx).p_3_2 = exp21(0);
				 ((Exp20Context)_localctx).result =  new clafer.Absyn.ECard(((Exp20Context)_localctx).p_3_2.result); 
				}
				break;
			case Surrogate_id_SYMB_27:
				enterOuterAlt(_localctx, 4);
				{
				setState(719);
				match(Surrogate_id_SYMB_27);
				setState(720);
				((Exp20Context)_localctx).p_4_2 = exp21(0);
				 ((Exp20Context)_localctx).result =  new clafer.Absyn.EMinExp(((Exp20Context)_localctx).p_4_2.result); 
				}
				break;
			case Surrogate_id_SYMB_46:
			case PosInteger:
			case PosDouble:
			case PosReal:
			case PosString:
			case PosIdent:
				enterOuterAlt(_localctx, 5);
				{
				setState(723);
				((Exp20Context)_localctx).p_5_1 = exp21(0);
				 ((Exp20Context)_localctx).result =  ((Exp20Context)_localctx).p_5_1.result; 
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

	public static class Exp21Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp21Context p_1_1;
		public Exp22Context p_2_1;
		public Exp22Context p_1_3;
		public Exp22Context exp22() {
			return getRuleContext(Exp22Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_31() { return getToken(claferParser.Surrogate_id_SYMB_31, 0); }
		public Exp21Context exp21() {
			return getRuleContext(Exp21Context.class,0);
		}
		public Exp21Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp21; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp21(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp21(this);
		}
	}

	public final Exp21Context exp21() throws RecognitionException {
		return exp21(0);
	}

	private Exp21Context exp21(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp21Context _localctx = new Exp21Context(_ctx, _parentState);
		Exp21Context _prevctx = _localctx;
		int _startState = 86;
		enterRecursionRule(_localctx, 86, RULE_exp21, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(729);
			((Exp21Context)_localctx).p_2_1 = exp22(0);
			 ((Exp21Context)_localctx).result =  ((Exp21Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(739);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp21Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp21);
					setState(732);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(733);
					match(Surrogate_id_SYMB_31);
					setState(734);
					((Exp21Context)_localctx).p_1_3 = exp22(0);
					 ((Exp21Context)_localctx).result =  new clafer.Absyn.EDomain(((Exp21Context)_localctx).p_1_1.result,((Exp21Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(741);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
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

	public static class Exp22Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp22Context p_1_1;
		public Exp23Context p_2_1;
		public Exp23Context p_1_3;
		public Exp23Context exp23() {
			return getRuleContext(Exp23Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_32() { return getToken(claferParser.Surrogate_id_SYMB_32, 0); }
		public Exp22Context exp22() {
			return getRuleContext(Exp22Context.class,0);
		}
		public Exp22Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp22; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp22(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp22(this);
		}
	}

	public final Exp22Context exp22() throws RecognitionException {
		return exp22(0);
	}

	private Exp22Context exp22(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp22Context _localctx = new Exp22Context(_ctx, _parentState);
		Exp22Context _prevctx = _localctx;
		int _startState = 88;
		enterRecursionRule(_localctx, 88, RULE_exp22, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(743);
			((Exp22Context)_localctx).p_2_1 = exp23(0);
			 ((Exp22Context)_localctx).result =  ((Exp22Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(753);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp22Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp22);
					setState(746);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(747);
					match(Surrogate_id_SYMB_32);
					setState(748);
					((Exp22Context)_localctx).p_1_3 = exp23(0);
					 ((Exp22Context)_localctx).result =  new clafer.Absyn.ERange(((Exp22Context)_localctx).p_1_1.result,((Exp22Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(755);
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

	public static class Exp23Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp23Context p_1_1;
		public Exp23Context p_2_1;
		public Exp24Context p_3_1;
		public Exp24Context p_1_3;
		public Exp24Context p_2_3;
		public Exp24Context exp24() {
			return getRuleContext(Exp24Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_33() { return getToken(claferParser.Surrogate_id_SYMB_33, 0); }
		public Exp23Context exp23() {
			return getRuleContext(Exp23Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_34() { return getToken(claferParser.Surrogate_id_SYMB_34, 0); }
		public Exp23Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp23; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp23(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp23(this);
		}
	}

	public final Exp23Context exp23() throws RecognitionException {
		return exp23(0);
	}

	private Exp23Context exp23(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp23Context _localctx = new Exp23Context(_ctx, _parentState);
		Exp23Context _prevctx = _localctx;
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_exp23, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(757);
			((Exp23Context)_localctx).p_3_1 = exp24(0);
			 ((Exp23Context)_localctx).result =  ((Exp23Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(772);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(770);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
					case 1:
						{
						_localctx = new Exp23Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp23);
						setState(760);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(761);
						match(Surrogate_id_SYMB_33);
						setState(762);
						((Exp23Context)_localctx).p_1_3 = exp24(0);
						 ((Exp23Context)_localctx).result =  new clafer.Absyn.EUnion(((Exp23Context)_localctx).p_1_1.result,((Exp23Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Exp23Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp23);
						setState(765);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(766);
						match(Surrogate_id_SYMB_34);
						setState(767);
						((Exp23Context)_localctx).p_2_3 = exp24(0);
						 ((Exp23Context)_localctx).result =  new clafer.Absyn.EUnionCom(((Exp23Context)_localctx).p_2_1.result,((Exp23Context)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(774);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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

	public static class Exp24Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp24Context p_1_1;
		public Exp25Context p_2_1;
		public Exp25Context p_1_3;
		public Exp25Context exp25() {
			return getRuleContext(Exp25Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_35() { return getToken(claferParser.Surrogate_id_SYMB_35, 0); }
		public Exp24Context exp24() {
			return getRuleContext(Exp24Context.class,0);
		}
		public Exp24Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp24; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp24(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp24(this);
		}
	}

	public final Exp24Context exp24() throws RecognitionException {
		return exp24(0);
	}

	private Exp24Context exp24(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp24Context _localctx = new Exp24Context(_ctx, _parentState);
		Exp24Context _prevctx = _localctx;
		int _startState = 92;
		enterRecursionRule(_localctx, 92, RULE_exp24, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(776);
			((Exp24Context)_localctx).p_2_1 = exp25(0);
			 ((Exp24Context)_localctx).result =  ((Exp24Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(786);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp24Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp24);
					setState(779);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(780);
					match(Surrogate_id_SYMB_35);
					setState(781);
					((Exp24Context)_localctx).p_1_3 = exp25(0);
					 ((Exp24Context)_localctx).result =  new clafer.Absyn.EDifference(((Exp24Context)_localctx).p_1_1.result,((Exp24Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(788);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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

	public static class Exp25Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp25Context p_1_1;
		public Exp26Context p_2_1;
		public Exp26Context p_1_3;
		public Exp26Context exp26() {
			return getRuleContext(Exp26Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_36() { return getToken(claferParser.Surrogate_id_SYMB_36, 0); }
		public Exp25Context exp25() {
			return getRuleContext(Exp25Context.class,0);
		}
		public Exp25Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp25; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp25(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp25(this);
		}
	}

	public final Exp25Context exp25() throws RecognitionException {
		return exp25(0);
	}

	private Exp25Context exp25(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp25Context _localctx = new Exp25Context(_ctx, _parentState);
		Exp25Context _prevctx = _localctx;
		int _startState = 94;
		enterRecursionRule(_localctx, 94, RULE_exp25, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(790);
			((Exp25Context)_localctx).p_2_1 = exp26(0);
			 ((Exp25Context)_localctx).result =  ((Exp25Context)_localctx).p_2_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(800);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exp25Context(_parentctx, _parentState);
					_localctx.p_1_1 = _prevctx;
					_localctx.p_1_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_exp25);
					setState(793);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(794);
					match(Surrogate_id_SYMB_36);
					setState(795);
					((Exp25Context)_localctx).p_1_3 = exp26(0);
					 ((Exp25Context)_localctx).result =  new clafer.Absyn.EIntersection(((Exp25Context)_localctx).p_1_1.result,((Exp25Context)_localctx).p_1_3.result); 
					}
					} 
				}
				setState(802);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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

	public static class Exp26Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp26Context p_1_1;
		public Exp26Context p_2_1;
		public Exp27Context p_3_1;
		public Exp27Context p_1_3;
		public Exp27Context p_2_3;
		public Exp27Context exp27() {
			return getRuleContext(Exp27Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_37() { return getToken(claferParser.Surrogate_id_SYMB_37, 0); }
		public Exp26Context exp26() {
			return getRuleContext(Exp26Context.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_38() { return getToken(claferParser.Surrogate_id_SYMB_38, 0); }
		public Exp26Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp26; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp26(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp26(this);
		}
	}

	public final Exp26Context exp26() throws RecognitionException {
		return exp26(0);
	}

	private Exp26Context exp26(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exp26Context _localctx = new Exp26Context(_ctx, _parentState);
		Exp26Context _prevctx = _localctx;
		int _startState = 96;
		enterRecursionRule(_localctx, 96, RULE_exp26, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(804);
			((Exp26Context)_localctx).p_3_1 = exp27();
			 ((Exp26Context)_localctx).result =  ((Exp26Context)_localctx).p_3_1.result; 
			}
			_ctx.stop = _input.LT(-1);
			setState(819);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(817);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
					case 1:
						{
						_localctx = new Exp26Context(_parentctx, _parentState);
						_localctx.p_1_1 = _prevctx;
						_localctx.p_1_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp26);
						setState(807);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(808);
						match(Surrogate_id_SYMB_37);
						setState(809);
						((Exp26Context)_localctx).p_1_3 = exp27();
						 ((Exp26Context)_localctx).result =  new clafer.Absyn.EIntersectionDeprecated(((Exp26Context)_localctx).p_1_1.result,((Exp26Context)_localctx).p_1_3.result); 
						}
						break;
					case 2:
						{
						_localctx = new Exp26Context(_parentctx, _parentState);
						_localctx.p_2_1 = _prevctx;
						_localctx.p_2_1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_exp26);
						setState(812);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(813);
						match(Surrogate_id_SYMB_38);
						setState(814);
						((Exp26Context)_localctx).p_2_3 = exp27();
						 ((Exp26Context)_localctx).result =  new clafer.Absyn.EJoin(((Exp26Context)_localctx).p_2_1.result,((Exp26Context)_localctx).p_2_3.result); 
						}
						break;
					}
					} 
				}
				setState(821);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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

	public static class Exp27Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public NameContext p_1_1;
		public Token p_2_1;
		public Token p_3_1;
		public Token p_4_1;
		public Token p_5_1;
		public ExpContext p_6_2;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode PosInteger() { return getToken(claferParser.PosInteger, 0); }
		public TerminalNode PosDouble() { return getToken(claferParser.PosDouble, 0); }
		public TerminalNode PosReal() { return getToken(claferParser.PosReal, 0); }
		public TerminalNode PosString() { return getToken(claferParser.PosString, 0); }
		public TerminalNode Surrogate_id_SYMB_46() { return getToken(claferParser.Surrogate_id_SYMB_46, 0); }
		public TerminalNode Surrogate_id_SYMB_47() { return getToken(claferParser.Surrogate_id_SYMB_47, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public Exp27Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp27; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp27(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp27(this);
		}
	}

	public final Exp27Context exp27() throws RecognitionException {
		Exp27Context _localctx = new Exp27Context(_ctx, getState());
		enterRule(_localctx, 98, RULE_exp27);
		try {
			setState(838);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PosIdent:
				enterOuterAlt(_localctx, 1);
				{
				setState(822);
				((Exp27Context)_localctx).p_1_1 = name();
				 ((Exp27Context)_localctx).result =  new clafer.Absyn.ClaferId(((Exp27Context)_localctx).p_1_1.result); 
				}
				break;
			case PosInteger:
				enterOuterAlt(_localctx, 2);
				{
				setState(825);
				((Exp27Context)_localctx).p_2_1 = match(PosInteger);
				 ((Exp27Context)_localctx).result =  new clafer.Absyn.EInt(((Exp27Context)_localctx).p_2_1.getText()); 
				}
				break;
			case PosDouble:
				enterOuterAlt(_localctx, 3);
				{
				setState(827);
				((Exp27Context)_localctx).p_3_1 = match(PosDouble);
				 ((Exp27Context)_localctx).result =  new clafer.Absyn.EDouble(((Exp27Context)_localctx).p_3_1.getText()); 
				}
				break;
			case PosReal:
				enterOuterAlt(_localctx, 4);
				{
				setState(829);
				((Exp27Context)_localctx).p_4_1 = match(PosReal);
				 ((Exp27Context)_localctx).result =  new clafer.Absyn.EReal(((Exp27Context)_localctx).p_4_1.getText()); 
				}
				break;
			case PosString:
				enterOuterAlt(_localctx, 5);
				{
				setState(831);
				((Exp27Context)_localctx).p_5_1 = match(PosString);
				 ((Exp27Context)_localctx).result =  new clafer.Absyn.EStr(((Exp27Context)_localctx).p_5_1.getText()); 
				}
				break;
			case Surrogate_id_SYMB_46:
				enterOuterAlt(_localctx, 6);
				{
				setState(833);
				match(Surrogate_id_SYMB_46);
				setState(834);
				((Exp27Context)_localctx).p_6_2 = exp();
				setState(835);
				match(Surrogate_id_SYMB_47);
				 ((Exp27Context)_localctx).result =  ((Exp27Context)_localctx).p_6_2.result; 
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

	public static class TransGuardContext extends ParserRuleContext {
		public clafer.Absyn.TransGuard result;
		public Exp1Context p_1_1;
		public Exp1Context exp1() {
			return getRuleContext(Exp1Context.class,0);
		}
		public TransGuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transGuard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterTransGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitTransGuard(this);
		}
	}

	public final TransGuardContext transGuard() throws RecognitionException {
		TransGuardContext _localctx = new TransGuardContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_transGuard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			((TransGuardContext)_localctx).p_1_1 = exp1();
			 ((TransGuardContext)_localctx).result =  new clafer.Absyn.TTransGuard(((TransGuardContext)_localctx).p_1_1.result); 
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

	public static class TransArrowContext extends ParserRuleContext {
		public clafer.Absyn.TransArrow result;
		public TransGuardContext p_2_2;
		public TransGuardContext p_4_2;
		public TerminalNode Surrogate_id_SYMB_39() { return getToken(claferParser.Surrogate_id_SYMB_39, 0); }
		public TerminalNode Surrogate_id_SYMB_40() { return getToken(claferParser.Surrogate_id_SYMB_40, 0); }
		public TerminalNode Surrogate_id_SYMB_41() { return getToken(claferParser.Surrogate_id_SYMB_41, 0); }
		public TransGuardContext transGuard() {
			return getRuleContext(TransGuardContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_42() { return getToken(claferParser.Surrogate_id_SYMB_42, 0); }
		public TerminalNode Surrogate_id_SYMB_43() { return getToken(claferParser.Surrogate_id_SYMB_43, 0); }
		public TransArrowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_transArrow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterTransArrow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitTransArrow(this);
		}
	}

	public final TransArrowContext transArrow() throws RecognitionException {
		TransArrowContext _localctx = new TransArrowContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_transArrow);
		try {
			setState(857);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(843);
				match(Surrogate_id_SYMB_39);
				 ((TransArrowContext)_localctx).result =  new clafer.Absyn.SyncTransArrow(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(845);
				match(Surrogate_id_SYMB_40);
				setState(846);
				((TransArrowContext)_localctx).p_2_2 = transGuard();
				setState(847);
				match(Surrogate_id_SYMB_41);
				 ((TransArrowContext)_localctx).result =  new clafer.Absyn.GuardedSyncTransArrow(((TransArrowContext)_localctx).p_2_2.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(850);
				match(Surrogate_id_SYMB_42);
				 ((TransArrowContext)_localctx).result =  new clafer.Absyn.NextTransArrow(); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(852);
				match(Surrogate_id_SYMB_40);
				setState(853);
				((TransArrowContext)_localctx).p_4_2 = transGuard();
				setState(854);
				match(Surrogate_id_SYMB_43);
				 ((TransArrowContext)_localctx).result =  new clafer.Absyn.GuardedNextTransArrow(((TransArrowContext)_localctx).p_4_2.result); 
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

	public static class PatternScopeContext extends ParserRuleContext {
		public clafer.Absyn.PatternScope result;
		public Exp11Context p_1_2;
		public Exp11Context p_2_2;
		public Exp11Context p_3_2;
		public Exp11Context p_3_4;
		public Exp11Context p_4_2;
		public Exp11Context p_4_4;
		public TerminalNode Surrogate_id_SYMB_59() { return getToken(claferParser.Surrogate_id_SYMB_59, 0); }
		public List<Exp11Context> exp11() {
			return getRuleContexts(Exp11Context.class);
		}
		public Exp11Context exp11(int i) {
			return getRuleContext(Exp11Context.class,i);
		}
		public TerminalNode Surrogate_id_SYMB_54() { return getToken(claferParser.Surrogate_id_SYMB_54, 0); }
		public TerminalNode Surrogate_id_SYMB_60() { return getToken(claferParser.Surrogate_id_SYMB_60, 0); }
		public TerminalNode Surrogate_id_SYMB_57() { return getToken(claferParser.Surrogate_id_SYMB_57, 0); }
		public TerminalNode Surrogate_id_SYMB_97() { return getToken(claferParser.Surrogate_id_SYMB_97, 0); }
		public PatternScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patternScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterPatternScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitPatternScope(this);
		}
	}

	public final PatternScopeContext patternScope() throws RecognitionException {
		PatternScopeContext _localctx = new PatternScopeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_patternScope);
		try {
			setState(880);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(859);
				match(Surrogate_id_SYMB_59);
				setState(860);
				((PatternScopeContext)_localctx).p_1_2 = exp11();
				 ((PatternScopeContext)_localctx).result =  new clafer.Absyn.PatScopeBefore(((PatternScopeContext)_localctx).p_1_2.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(863);
				match(Surrogate_id_SYMB_54);
				setState(864);
				((PatternScopeContext)_localctx).p_2_2 = exp11();
				 ((PatternScopeContext)_localctx).result =  new clafer.Absyn.PatScopeAfter(((PatternScopeContext)_localctx).p_2_2.result); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(867);
				match(Surrogate_id_SYMB_60);
				setState(868);
				((PatternScopeContext)_localctx).p_3_2 = exp11();
				setState(869);
				match(Surrogate_id_SYMB_57);
				setState(870);
				((PatternScopeContext)_localctx).p_3_4 = exp11();
				 ((PatternScopeContext)_localctx).result =  new clafer.Absyn.PatScopeBetweenAnd(((PatternScopeContext)_localctx).p_3_2.result,((PatternScopeContext)_localctx).p_3_4.result); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(873);
				match(Surrogate_id_SYMB_54);
				setState(874);
				((PatternScopeContext)_localctx).p_4_2 = exp11();
				setState(875);
				match(Surrogate_id_SYMB_97);
				setState(876);
				((PatternScopeContext)_localctx).p_4_4 = exp11();
				 ((PatternScopeContext)_localctx).result =  new clafer.Absyn.PatScopeAfterUntil(((PatternScopeContext)_localctx).p_4_2.result,((PatternScopeContext)_localctx).p_4_4.result); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				 ((PatternScopeContext)_localctx).result =  new clafer.Absyn.PatScopeEmpty(); 
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

	public static class DeclContext extends ParserRuleContext {
		public clafer.Absyn.Decl result;
		public ListLocIdContext p_1_1;
		public Exp21Context p_1_3;
		public TerminalNode Surrogate_id_SYMB_8() { return getToken(claferParser.Surrogate_id_SYMB_8, 0); }
		public ListLocIdContext listLocId() {
			return getRuleContext(ListLocIdContext.class,0);
		}
		public Exp21Context exp21() {
			return getRuleContext(Exp21Context.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(882);
			((DeclContext)_localctx).p_1_1 = listLocId();
			setState(883);
			match(Surrogate_id_SYMB_8);
			setState(884);
			((DeclContext)_localctx).p_1_3 = exp21(0);
			 ((DeclContext)_localctx).result =  new clafer.Absyn.DDecl(((DeclContext)_localctx).p_1_1.result,((DeclContext)_localctx).p_1_3.result); 
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

	public static class VarBindingContext extends ParserRuleContext {
		public clafer.Absyn.VarBinding result;
		public LocIdContext p_1_1;
		public NameContext p_1_3;
		public TerminalNode Surrogate_id_SYMB_0() { return getToken(claferParser.Surrogate_id_SYMB_0, 0); }
		public LocIdContext locId() {
			return getRuleContext(LocIdContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public VarBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterVarBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitVarBinding(this);
		}
	}

	public final VarBindingContext varBinding() throws RecognitionException {
		VarBindingContext _localctx = new VarBindingContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_varBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			((VarBindingContext)_localctx).p_1_1 = locId();
			setState(888);
			match(Surrogate_id_SYMB_0);
			setState(889);
			((VarBindingContext)_localctx).p_1_3 = name();
			 ((VarBindingContext)_localctx).result =  new clafer.Absyn.VVarBinding(((VarBindingContext)_localctx).p_1_1.result,((VarBindingContext)_localctx).p_1_3.result); 
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

	public static class QuantContext extends ParserRuleContext {
		public clafer.Absyn.Quant result;
		public TerminalNode Surrogate_id_SYMB_86() { return getToken(claferParser.Surrogate_id_SYMB_86, 0); }
		public TerminalNode Surrogate_id_SYMB_87() { return getToken(claferParser.Surrogate_id_SYMB_87, 0); }
		public TerminalNode Surrogate_id_SYMB_77() { return getToken(claferParser.Surrogate_id_SYMB_77, 0); }
		public TerminalNode Surrogate_id_SYMB_88() { return getToken(claferParser.Surrogate_id_SYMB_88, 0); }
		public TerminalNode Surrogate_id_SYMB_93() { return getToken(claferParser.Surrogate_id_SYMB_93, 0); }
		public QuantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterQuant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitQuant(this);
		}
	}

	public final QuantContext quant() throws RecognitionException {
		QuantContext _localctx = new QuantContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_quant);
		try {
			setState(902);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Surrogate_id_SYMB_86:
				enterOuterAlt(_localctx, 1);
				{
				setState(892);
				match(Surrogate_id_SYMB_86);
				 ((QuantContext)_localctx).result =  new clafer.Absyn.QuantNo(); 
				}
				break;
			case Surrogate_id_SYMB_87:
				enterOuterAlt(_localctx, 2);
				{
				setState(894);
				match(Surrogate_id_SYMB_87);
				 ((QuantContext)_localctx).result =  new clafer.Absyn.QuantNot(); 
				}
				break;
			case Surrogate_id_SYMB_77:
				enterOuterAlt(_localctx, 3);
				{
				setState(896);
				match(Surrogate_id_SYMB_77);
				 ((QuantContext)_localctx).result =  new clafer.Absyn.QuantLone(); 
				}
				break;
			case Surrogate_id_SYMB_88:
				enterOuterAlt(_localctx, 4);
				{
				setState(898);
				match(Surrogate_id_SYMB_88);
				 ((QuantContext)_localctx).result =  new clafer.Absyn.QuantOne(); 
				}
				break;
			case Surrogate_id_SYMB_93:
				enterOuterAlt(_localctx, 5);
				{
				setState(900);
				match(Surrogate_id_SYMB_93);
				 ((QuantContext)_localctx).result =  new clafer.Absyn.QuantSome(); 
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

	public static class EnumIdContext extends ParserRuleContext {
		public clafer.Absyn.EnumId result;
		public Token p_1_1;
		public TerminalNode PosIdent() { return getToken(claferParser.PosIdent, 0); }
		public EnumIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterEnumId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitEnumId(this);
		}
	}

	public final EnumIdContext enumId() throws RecognitionException {
		EnumIdContext _localctx = new EnumIdContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_enumId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
			((EnumIdContext)_localctx).p_1_1 = match(PosIdent);
			 ((EnumIdContext)_localctx).result =  new clafer.Absyn.EnumIdIdent(((EnumIdContext)_localctx).p_1_1.getText()); 
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

	public static class ModIdContext extends ParserRuleContext {
		public clafer.Absyn.ModId result;
		public Token p_1_1;
		public TerminalNode PosIdent() { return getToken(claferParser.PosIdent, 0); }
		public ModIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterModId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitModId(this);
		}
	}

	public final ModIdContext modId() throws RecognitionException {
		ModIdContext _localctx = new ModIdContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_modId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(907);
			((ModIdContext)_localctx).p_1_1 = match(PosIdent);
			 ((ModIdContext)_localctx).result =  new clafer.Absyn.ModIdIdent(((ModIdContext)_localctx).p_1_1.getText()); 
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

	public static class LocIdContext extends ParserRuleContext {
		public clafer.Absyn.LocId result;
		public Token p_1_1;
		public TerminalNode PosIdent() { return getToken(claferParser.PosIdent, 0); }
		public LocIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterLocId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitLocId(this);
		}
	}

	public final LocIdContext locId() throws RecognitionException {
		LocIdContext _localctx = new LocIdContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_locId);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(910);
			((LocIdContext)_localctx).p_1_1 = match(PosIdent);
			 ((LocIdContext)_localctx).result =  new clafer.Absyn.LocIdIdent(((LocIdContext)_localctx).p_1_1.getText()); 
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

	public static class ListDeclarationContext extends ParserRuleContext {
		public clafer.Absyn.ListDeclaration result;
		public ListDeclarationContext p_2_1;
		public DeclarationContext p_2_2;
		public ListDeclarationContext listDeclaration() {
			return getRuleContext(ListDeclarationContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public ListDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterListDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitListDeclaration(this);
		}
	}

	public final ListDeclarationContext listDeclaration() throws RecognitionException {
		return listDeclaration(0);
	}

	private ListDeclarationContext listDeclaration(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ListDeclarationContext _localctx = new ListDeclarationContext(_ctx, _parentState);
		ListDeclarationContext _prevctx = _localctx;
		int _startState = 118;
		enterRecursionRule(_localctx, 118, RULE_listDeclaration, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			 ((ListDeclarationContext)_localctx).result =  new clafer.Absyn.ListDeclaration(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(922);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListDeclarationContext(_parentctx, _parentState);
					_localctx.p_2_1 = _prevctx;
					_localctx.p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_listDeclaration);
					setState(916);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(917);
					((ListDeclarationContext)_localctx).p_2_2 = declaration();
					 ((ListDeclarationContext)_localctx).result =  ((ListDeclarationContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListDeclarationContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(924);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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

	public static class ListEnumIdContext extends ParserRuleContext {
		public clafer.Absyn.ListEnumId result;
		public EnumIdContext p_1_1;
		public EnumIdContext p_2_1;
		public ListEnumIdContext p_2_3;
		public EnumIdContext enumId() {
			return getRuleContext(EnumIdContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_16() { return getToken(claferParser.Surrogate_id_SYMB_16, 0); }
		public ListEnumIdContext listEnumId() {
			return getRuleContext(ListEnumIdContext.class,0);
		}
		public ListEnumIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listEnumId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterListEnumId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitListEnumId(this);
		}
	}

	public final ListEnumIdContext listEnumId() throws RecognitionException {
		ListEnumIdContext _localctx = new ListEnumIdContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_listEnumId);
		try {
			setState(933);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(925);
				((ListEnumIdContext)_localctx).p_1_1 = enumId();
				 ((ListEnumIdContext)_localctx).result =  new clafer.Absyn.ListEnumId(); _localctx.result.addLast(((ListEnumIdContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(928);
				((ListEnumIdContext)_localctx).p_2_1 = enumId();
				setState(929);
				match(Surrogate_id_SYMB_16);
				setState(930);
				((ListEnumIdContext)_localctx).p_2_3 = listEnumId();
				 ((ListEnumIdContext)_localctx).result =  ((ListEnumIdContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListEnumIdContext)_localctx).p_2_1.result); 
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

	public static class ListElementContext extends ParserRuleContext {
		public clafer.Absyn.ListElement result;
		public ListElementContext p_2_1;
		public ElementContext p_2_2;
		public ListElementContext listElement() {
			return getRuleContext(ListElementContext.class,0);
		}
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public ListElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterListElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitListElement(this);
		}
	}

	public final ListElementContext listElement() throws RecognitionException {
		return listElement(0);
	}

	private ListElementContext listElement(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ListElementContext _localctx = new ListElementContext(_ctx, _parentState);
		ListElementContext _prevctx = _localctx;
		int _startState = 122;
		enterRecursionRule(_localctx, 122, RULE_listElement, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			 ((ListElementContext)_localctx).result =  new clafer.Absyn.ListElement(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(944);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListElementContext(_parentctx, _parentState);
					_localctx.p_2_1 = _prevctx;
					_localctx.p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_listElement);
					setState(938);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(939);
					((ListElementContext)_localctx).p_2_2 = element();
					 ((ListElementContext)_localctx).result =  ((ListElementContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListElementContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(946);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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

	public static class ListExpContext extends ParserRuleContext {
		public clafer.Absyn.ListExp result;
		public ListExpContext p_2_1;
		public ExpContext p_2_2;
		public ListExpContext listExp() {
			return getRuleContext(ListExpContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ListExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterListExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitListExp(this);
		}
	}

	public final ListExpContext listExp() throws RecognitionException {
		return listExp(0);
	}

	private ListExpContext listExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ListExpContext _localctx = new ListExpContext(_ctx, _parentState);
		ListExpContext _prevctx = _localctx;
		int _startState = 124;
		enterRecursionRule(_localctx, 124, RULE_listExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			 ((ListExpContext)_localctx).result =  new clafer.Absyn.ListExp(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(956);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListExpContext(_parentctx, _parentState);
					_localctx.p_2_1 = _prevctx;
					_localctx.p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_listExp);
					setState(950);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(951);
					((ListExpContext)_localctx).p_2_2 = exp();
					 ((ListExpContext)_localctx).result =  ((ListExpContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListExpContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(958);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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

	public static class ListTempModifierContext extends ParserRuleContext {
		public clafer.Absyn.ListTempModifier result;
		public ListTempModifierContext p_2_1;
		public TempModifierContext p_2_2;
		public ListTempModifierContext listTempModifier() {
			return getRuleContext(ListTempModifierContext.class,0);
		}
		public TempModifierContext tempModifier() {
			return getRuleContext(TempModifierContext.class,0);
		}
		public ListTempModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listTempModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterListTempModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitListTempModifier(this);
		}
	}

	public final ListTempModifierContext listTempModifier() throws RecognitionException {
		return listTempModifier(0);
	}

	private ListTempModifierContext listTempModifier(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ListTempModifierContext _localctx = new ListTempModifierContext(_ctx, _parentState);
		ListTempModifierContext _prevctx = _localctx;
		int _startState = 126;
		enterRecursionRule(_localctx, 126, RULE_listTempModifier, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			 ((ListTempModifierContext)_localctx).result =  new clafer.Absyn.ListTempModifier(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(968);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ListTempModifierContext(_parentctx, _parentState);
					_localctx.p_2_1 = _prevctx;
					_localctx.p_2_1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_listTempModifier);
					setState(962);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(963);
					((ListTempModifierContext)_localctx).p_2_2 = tempModifier();
					 ((ListTempModifierContext)_localctx).result =  ((ListTempModifierContext)_localctx).p_2_1.result; _localctx.result.addLast(((ListTempModifierContext)_localctx).p_2_2.result); 
					}
					} 
				}
				setState(970);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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

	public static class ListLocIdContext extends ParserRuleContext {
		public clafer.Absyn.ListLocId result;
		public LocIdContext p_1_1;
		public LocIdContext p_2_1;
		public ListLocIdContext p_2_3;
		public LocIdContext locId() {
			return getRuleContext(LocIdContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_44() { return getToken(claferParser.Surrogate_id_SYMB_44, 0); }
		public ListLocIdContext listLocId() {
			return getRuleContext(ListLocIdContext.class,0);
		}
		public ListLocIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLocId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterListLocId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitListLocId(this);
		}
	}

	public final ListLocIdContext listLocId() throws RecognitionException {
		ListLocIdContext _localctx = new ListLocIdContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_listLocId);
		try {
			setState(979);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(971);
				((ListLocIdContext)_localctx).p_1_1 = locId();
				 ((ListLocIdContext)_localctx).result =  new clafer.Absyn.ListLocId(); _localctx.result.addLast(((ListLocIdContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(974);
				((ListLocIdContext)_localctx).p_2_1 = locId();
				setState(975);
				match(Surrogate_id_SYMB_44);
				setState(976);
				((ListLocIdContext)_localctx).p_2_3 = listLocId();
				 ((ListLocIdContext)_localctx).result =  ((ListLocIdContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListLocIdContext)_localctx).p_2_1.result); 
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

	public static class ListModIdContext extends ParserRuleContext {
		public clafer.Absyn.ListModId result;
		public ModIdContext p_1_1;
		public ModIdContext p_2_1;
		public ListModIdContext p_2_3;
		public ModIdContext modId() {
			return getRuleContext(ModIdContext.class,0);
		}
		public TerminalNode Surrogate_id_SYMB_45() { return getToken(claferParser.Surrogate_id_SYMB_45, 0); }
		public ListModIdContext listModId() {
			return getRuleContext(ListModIdContext.class,0);
		}
		public ListModIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listModId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterListModId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitListModId(this);
		}
	}

	public final ListModIdContext listModId() throws RecognitionException {
		ListModIdContext _localctx = new ListModIdContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_listModId);
		try {
			setState(989);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(981);
				((ListModIdContext)_localctx).p_1_1 = modId();
				 ((ListModIdContext)_localctx).result =  new clafer.Absyn.ListModId(); _localctx.result.addLast(((ListModIdContext)_localctx).p_1_1.result); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(984);
				((ListModIdContext)_localctx).p_2_1 = modId();
				setState(985);
				match(Surrogate_id_SYMB_45);
				setState(986);
				((ListModIdContext)_localctx).p_2_3 = listModId();
				 ((ListModIdContext)_localctx).result =  ((ListModIdContext)_localctx).p_2_3.result; _localctx.result.addFirst(((ListModIdContext)_localctx).p_2_1.result); 
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

	public static class Exp12Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp13Context p_1_1;
		public Exp13Context exp13() {
			return getRuleContext(Exp13Context.class,0);
		}
		public Exp12Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp12; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp12(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp12(this);
		}
	}

	public final Exp12Context exp12() throws RecognitionException {
		Exp12Context _localctx = new Exp12Context(_ctx, getState());
		enterRule(_localctx, 132, RULE_exp12);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991);
			((Exp12Context)_localctx).p_1_1 = exp13();
			 ((Exp12Context)_localctx).result =  ((Exp12Context)_localctx).p_1_1.result; 
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

	public static class Exp13Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp14Context p_1_1;
		public Exp14Context exp14() {
			return getRuleContext(Exp14Context.class,0);
		}
		public Exp13Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp13; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp13(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp13(this);
		}
	}

	public final Exp13Context exp13() throws RecognitionException {
		Exp13Context _localctx = new Exp13Context(_ctx, getState());
		enterRule(_localctx, 134, RULE_exp13);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(994);
			((Exp13Context)_localctx).p_1_1 = exp14();
			 ((Exp13Context)_localctx).result =  ((Exp13Context)_localctx).p_1_1.result; 
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

	public static class Exp14Context extends ParserRuleContext {
		public clafer.Absyn.Exp result;
		public Exp15Context p_1_1;
		public Exp15Context exp15() {
			return getRuleContext(Exp15Context.class,0);
		}
		public Exp14Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp14; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).enterExp14(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof claferParserListener ) ((claferParserListener)listener).exitExp14(this);
		}
	}

	public final Exp14Context exp14() throws RecognitionException {
		Exp14Context _localctx = new Exp14Context(_ctx, getState());
		enterRule(_localctx, 136, RULE_exp14);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(997);
			((Exp14Context)_localctx).p_1_1 = exp15(0);
			 ((Exp14Context)_localctx).result =  ((Exp14Context)_localctx).p_1_1.result; 
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
		case 28:
			return exp3_sempred((Exp3Context)_localctx, predIndex);
		case 29:
			return exp4_sempred((Exp4Context)_localctx, predIndex);
		case 30:
			return exp5_sempred((Exp5Context)_localctx, predIndex);
		case 31:
			return exp6_sempred((Exp6Context)_localctx, predIndex);
		case 32:
			return exp7_sempred((Exp7Context)_localctx, predIndex);
		case 33:
			return exp8_sempred((Exp8Context)_localctx, predIndex);
		case 34:
			return exp9_sempred((Exp9Context)_localctx, predIndex);
		case 37:
			return exp15_sempred((Exp15Context)_localctx, predIndex);
		case 39:
			return exp17_sempred((Exp17Context)_localctx, predIndex);
		case 40:
			return exp18_sempred((Exp18Context)_localctx, predIndex);
		case 43:
			return exp21_sempred((Exp21Context)_localctx, predIndex);
		case 44:
			return exp22_sempred((Exp22Context)_localctx, predIndex);
		case 45:
			return exp23_sempred((Exp23Context)_localctx, predIndex);
		case 46:
			return exp24_sempred((Exp24Context)_localctx, predIndex);
		case 47:
			return exp25_sempred((Exp25Context)_localctx, predIndex);
		case 48:
			return exp26_sempred((Exp26Context)_localctx, predIndex);
		case 59:
			return listDeclaration_sempred((ListDeclarationContext)_localctx, predIndex);
		case 61:
			return listElement_sempred((ListElementContext)_localctx, predIndex);
		case 62:
			return listExp_sempred((ListExpContext)_localctx, predIndex);
		case 63:
			return listTempModifier_sempred((ListTempModifierContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp3_sempred(Exp3Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp4_sempred(Exp4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp5_sempred(Exp5Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp6_sempred(Exp6Context _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp7_sempred(Exp7Context _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp8_sempred(Exp8Context _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp9_sempred(Exp9Context _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 3);
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp15_sempred(Exp15Context _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 8);
		case 11:
			return precpred(_ctx, 7);
		case 12:
			return precpred(_ctx, 6);
		case 13:
			return precpred(_ctx, 5);
		case 14:
			return precpred(_ctx, 4);
		case 15:
			return precpred(_ctx, 3);
		case 16:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp17_sempred(Exp17Context _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 3);
		case 18:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp18_sempred(Exp18Context _localctx, int predIndex) {
		switch (predIndex) {
		case 19:
			return precpred(_ctx, 4);
		case 20:
			return precpred(_ctx, 3);
		case 21:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp21_sempred(Exp21Context _localctx, int predIndex) {
		switch (predIndex) {
		case 22:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp22_sempred(Exp22Context _localctx, int predIndex) {
		switch (predIndex) {
		case 23:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp23_sempred(Exp23Context _localctx, int predIndex) {
		switch (predIndex) {
		case 24:
			return precpred(_ctx, 3);
		case 25:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp24_sempred(Exp24Context _localctx, int predIndex) {
		switch (predIndex) {
		case 26:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp25_sempred(Exp25Context _localctx, int predIndex) {
		switch (predIndex) {
		case 27:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp26_sempred(Exp26Context _localctx, int predIndex) {
		switch (predIndex) {
		case 28:
			return precpred(_ctx, 3);
		case 29:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean listDeclaration_sempred(ListDeclarationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 30:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean listElement_sempred(ListElementContext _localctx, int predIndex) {
		switch (predIndex) {
		case 31:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean listExp_sempred(ListExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 32:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean listTempModifier_sempred(ListTempModifierContext _localctx, int predIndex) {
		switch (predIndex) {
		case 33:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3q\u03eb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ad\n\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00de\n\f\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u00e8\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u00ef\n"+
		"\16\3\17\3\17\3\17\5\17\u00f4\n\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00fc\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0110\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u0117\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0122"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\5\24\u0129\n\24\3\25\3\25\3\25\3\25\5\25"+
		"\u012f\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u013d\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u014b\n\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\5\31"+
		"\u0156\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33"+
		"\u0163\n\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\5\34\u0190\n\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01bf\n\35\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u01ca\n\36\f\36\16\36\u01cd\13"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\7\37\u01d8\n\37\f\37"+
		"\16\37\u01db\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u01e6\n \f \16 \u01e9"+
		"\13 \3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u01f4\n!\f!\16!\u01f7\13!\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\7\"\u0202\n\"\f\"\16\"\u0205\13\"\3#\3#\3#"+
		"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\7#\u0215\n#\f#\16#\u0218\13#\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\7$\u0228\n$\f$\16$\u022b\13$\3%\3%"+
		"\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%"+
		"\3%\3%\5%\u0248\n%\3&\3&\3&\3&\3&\3&\3&\5&\u0251\n&\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\7\'\u0280\n\'\f\'\16\'\u0283\13\'\3(\3(\3(\3(\3"+
		"(\3(\3(\5(\u028c\n(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u029c"+
		"\n)\f)\16)\u029f\13)\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3*\3"+
		"*\3*\3*\7*\u02b4\n*\f*\16*\u02b7\13*\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3+"+
		"\5+\u02c4\n+\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,\3,"+
		"\5,\u02d9\n,\3-\3-\3-\3-\3-\3-\3-\3-\3-\7-\u02e4\n-\f-\16-\u02e7\13-\3"+
		".\3.\3.\3.\3.\3.\3.\3.\3.\7.\u02f2\n.\f.\16.\u02f5\13.\3/\3/\3/\3/\3/"+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3/\7/\u0305\n/\f/\16/\u0308\13/\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\7\60\u0313\n\60\f\60\16\60\u0316\13\60"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\7\61\u0321\n\61\f\61\16"+
		"\61\u0324\13\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\3\62\3\62\3\62\7\62\u0334\n\62\f\62\16\62\u0337\13\62\3\63\3\63\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63"+
		"\u0349\n\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\3\65\5\65\u035c\n\65\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66\3\66"+
		"\3\66\5\66\u0373\n\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\3"+
		"9\39\39\39\39\39\39\39\59\u0389\n9\3:\3:\3:\3;\3;\3;\3<\3<\3<\3=\3=\3"+
		"=\3=\3=\3=\3=\7=\u039b\n=\f=\16=\u039e\13=\3>\3>\3>\3>\3>\3>\3>\3>\5>"+
		"\u03a8\n>\3?\3?\3?\3?\3?\3?\3?\7?\u03b1\n?\f?\16?\u03b4\13?\3@\3@\3@\3"+
		"@\3@\3@\3@\7@\u03bd\n@\f@\16@\u03c0\13@\3A\3A\3A\3A\3A\3A\3A\7A\u03c9"+
		"\nA\fA\16A\u03cc\13A\3B\3B\3B\3B\3B\3B\3B\3B\5B\u03d6\nB\3C\3C\3C\3C\3"+
		"C\3C\3C\3C\5C\u03e0\nC\3D\3D\3D\3E\3E\3E\3F\3F\3F\3F\2\26:<>@BDFLPRXZ"+
		"\\^`bx|~\u0080G\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\2\2\2\u0415\2\u008c\3\2\2\2\4\u0090\3\2\2\2\6\u0094\3\2\2\2\b\u0098"+
		"\3\2\2\2\n\u009c\3\2\2\2\f\u00a0\3\2\2\2\16\u00ac\3\2\2\2\20\u00ae\3\2"+
		"\2\2\22\u00ba\3\2\2\2\24\u00bf\3\2\2\2\26\u00dd\3\2\2\2\30\u00e7\3\2\2"+
		"\2\32\u00ee\3\2\2\2\34\u00f3\3\2\2\2\36\u00fb\3\2\2\2 \u010f\3\2\2\2\""+
		"\u0116\3\2\2\2$\u0121\3\2\2\2&\u0128\3\2\2\2(\u012e\3\2\2\2*\u013c\3\2"+
		"\2\2,\u014a\3\2\2\2.\u014c\3\2\2\2\60\u0155\3\2\2\2\62\u0157\3\2\2\2\64"+
		"\u0162\3\2\2\2\66\u018f\3\2\2\28\u01be\3\2\2\2:\u01c0\3\2\2\2<\u01ce\3"+
		"\2\2\2>\u01dc\3\2\2\2@\u01ea\3\2\2\2B\u01f8\3\2\2\2D\u0206\3\2\2\2F\u0219"+
		"\3\2\2\2H\u0247\3\2\2\2J\u0250\3\2\2\2L\u0252\3\2\2\2N\u028b\3\2\2\2P"+
		"\u028d\3\2\2\2R\u02a0\3\2\2\2T\u02c3\3\2\2\2V\u02d8\3\2\2\2X\u02da\3\2"+
		"\2\2Z\u02e8\3\2\2\2\\\u02f6\3\2\2\2^\u0309\3\2\2\2`\u0317\3\2\2\2b\u0325"+
		"\3\2\2\2d\u0348\3\2\2\2f\u034a\3\2\2\2h\u035b\3\2\2\2j\u0372\3\2\2\2l"+
		"\u0374\3\2\2\2n\u0379\3\2\2\2p\u0388\3\2\2\2r\u038a\3\2\2\2t\u038d\3\2"+
		"\2\2v\u0390\3\2\2\2x\u0393\3\2\2\2z\u03a7\3\2\2\2|\u03a9\3\2\2\2~\u03b5"+
		"\3\2\2\2\u0080\u03c1\3\2\2\2\u0082\u03d5\3\2\2\2\u0084\u03df\3\2\2\2\u0086"+
		"\u03e1\3\2\2\2\u0088\u03e4\3\2\2\2\u008a\u03e7\3\2\2\2\u008c\u008d\5\f"+
		"\7\2\u008d\u008e\7\2\2\3\u008e\u008f\b\2\1\2\u008f\3\3\2\2\2\u0090\u0091"+
		"\5\20\t\2\u0091\u0092\7\2\2\3\u0092\u0093\b\3\1\2\u0093\5\3\2\2\2\u0094"+
		"\u0095\5\22\n\2\u0095\u0096\7\2\2\3\u0096\u0097\b\4\1\2\u0097\7\3\2\2"+
		"\2\u0098\u0099\5\24\13\2\u0099\u009a\7\2\2\3\u009a\u009b\b\5\1\2\u009b"+
		"\t\3\2\2\2\u009c\u009d\5\26\f\2\u009d\u009e\7\2\2\3\u009e\u009f\b\6\1"+
		"\2\u009f\13\3\2\2\2\u00a0\u00a1\5x=\2\u00a1\u00a2\b\7\1\2\u00a2\r\3\2"+
		"\2\2\u00a3\u00a4\7B\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7\3\2\2\u00a6\u00a7"+
		"\5z>\2\u00a7\u00a8\b\b\1\2\u00a8\u00ad\3\2\2\2\u00a9\u00aa\5 \21\2\u00aa"+
		"\u00ab\b\b\1\2\u00ab\u00ad\3\2\2\2\u00ac\u00a3\3\2\2\2\u00ac\u00a9\3\2"+
		"\2\2\u00ad\17\3\2\2\2\u00ae\u00af\5\34\17\2\u00af\u00b0\5\u0080A\2\u00b0"+
		"\u00b1\5*\26\2\u00b1\u00b2\7k\2\2\u00b2\u00b3\5\"\22\2\u00b3\u00b4\5$"+
		"\23\2\u00b4\u00b5\5,\27\2\u00b5\u00b6\5&\24\2\u00b6\u00b7\5\32\16\2\u00b7"+
		"\u00b8\5\36\20\2\u00b8\u00b9\b\t\1\2\u00b9\21\3\2\2\2\u00ba\u00bb\7\4"+
		"\2\2\u00bb\u00bc\5~@\2\u00bc\u00bd\7\5\2\2\u00bd\u00be\b\n\1\2\u00be\23"+
		"\3\2\2\2\u00bf\u00c0\7=\2\2\u00c0\u00c1\7\4\2\2\u00c1\u00c2\5~@\2\u00c2"+
		"\u00c3\7\5\2\2\u00c3\u00c4\b\13\1\2\u00c4\25\3\2\2\2\u00c5\u00c6\7\6\2"+
		"\2\u00c6\u00c7\7S\2\2\u00c7\u00c8\5~@\2\u00c8\u00c9\7\7\2\2\u00c9\u00ca"+
		"\b\f\1\2\u00ca\u00de\3\2\2\2\u00cb\u00cc\7\6\2\2\u00cc\u00cd\7Q\2\2\u00cd"+
		"\u00ce\5~@\2\u00ce\u00cf\7\7\2\2\u00cf\u00d0\b\f\1\2\u00d0\u00de\3\2\2"+
		"\2\u00d1\u00d2\7\6\2\2\u00d2\u00d3\7T\2\2\u00d3\u00d4\5~@\2\u00d4\u00d5"+
		"\7\7\2\2\u00d5\u00d6\b\f\1\2\u00d6\u00de\3\2\2\2\u00d7\u00d8\7\6\2\2\u00d8"+
		"\u00d9\7R\2\2\u00d9\u00da\5~@\2\u00da\u00db\7\7\2\2\u00db\u00dc\b\f\1"+
		"\2\u00dc\u00de\3\2\2\2\u00dd\u00c5\3\2\2\2\u00dd\u00cb\3\2\2\2\u00dd\u00d1"+
		"\3\2\2\2\u00dd\u00d7\3\2\2\2\u00de\27\3\2\2\2\u00df\u00e0\7L\2\2\u00e0"+
		"\u00e8\b\r\1\2\u00e1\u00e2\7D\2\2\u00e2\u00e8\b\r\1\2\u00e3\u00e4\7F\2"+
		"\2\u00e4\u00e8\b\r\1\2\u00e5\u00e6\7G\2\2\u00e6\u00e8\b\r\1\2\u00e7\u00df"+
		"\3\2\2\2\u00e7\u00e1\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8"+
		"\31\3\2\2\2\u00e9\u00ef\b\16\1\2\u00ea\u00eb\5h\65\2\u00eb\u00ec\5\64"+
		"\33\2\u00ec\u00ed\b\16\1\2\u00ed\u00ef\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ee"+
		"\u00ea\3\2\2\2\u00ef\33\3\2\2\2\u00f0\u00f4\b\17\1\2\u00f1\u00f2\78\2"+
		"\2\u00f2\u00f4\b\17\1\2\u00f3\u00f0\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4"+
		"\35\3\2\2\2\u00f5\u00fc\b\20\1\2\u00f6\u00f7\7\b\2\2\u00f7\u00f8\5|?\2"+
		"\u00f8\u00f9\7\t\2\2\u00f9\u00fa\b\20\1\2\u00fa\u00fc\3\2\2\2\u00fb\u00f5"+
		"\3\2\2\2\u00fb\u00f6\3\2\2\2\u00fc\37\3\2\2\2\u00fd\u00fe\5\20\t\2\u00fe"+
		"\u00ff\b\21\1\2\u00ff\u0110\3\2\2\2\u0100\u0101\7\n\2\2\u0101\u0102\5"+
		"\62\32\2\u0102\u0103\5,\27\2\u0103\u0104\5\36\20\2\u0104\u0105\b\21\1"+
		"\2\u0105\u0110\3\2\2\2\u0106\u0107\5\22\n\2\u0107\u0108\b\21\1\2\u0108"+
		"\u0110\3\2\2\2\u0109\u010a\5\26\f\2\u010a\u010b\b\21\1\2\u010b\u0110\3"+
		"\2\2\2\u010c\u010d\5\24\13\2\u010d\u010e\b\21\1\2\u010e\u0110\3\2\2\2"+
		"\u010f\u00fd\3\2\2\2\u010f\u0100\3\2\2\2\u010f\u0106\3\2\2\2\u010f\u0109"+
		"\3\2\2\2\u010f\u010c\3\2\2\2\u0110!\3\2\2\2\u0111\u0117\b\22\1\2\u0112"+
		"\u0113\7\13\2\2\u0113\u0114\5b\62\2\u0114\u0115\b\22\1\2\u0115\u0117\3"+
		"\2\2\2\u0116\u0111\3\2\2\2\u0116\u0112\3\2\2\2\u0117#\3\2\2\2\u0118\u0122"+
		"\b\23\1\2\u0119\u011a\7\f\2\2\u011a\u011b\5\\/\2\u011b\u011c\b\23\1\2"+
		"\u011c\u0122\3\2\2\2\u011d\u011e\7\r\2\2\u011e\u011f\5\\/\2\u011f\u0120"+
		"\b\23\1\2\u0120\u0122\3\2\2\2\u0121\u0118\3\2\2\2\u0121\u0119\3\2\2\2"+
		"\u0121\u011d\3\2\2\2\u0122%\3\2\2\2\u0123\u0129\b\24\1\2\u0124\u0125\5"+
		"(\25\2\u0125\u0126\5\64\33\2\u0126\u0127\b\24\1\2\u0127\u0129\3\2\2\2"+
		"\u0128\u0123\3\2\2\2\u0128\u0124\3\2\2\2\u0129\'\3\2\2\2\u012a\u012b\7"+
		"\3\2\2\u012b\u012f\b\25\1\2\u012c\u012d\7\16\2\2\u012d\u012f\b\25\1\2"+
		"\u012e\u012a\3\2\2\2\u012e\u012c\3\2\2\2\u012f)\3\2\2\2\u0130\u013d\b"+
		"\26\1\2\u0131\u0132\7f\2\2\u0132\u013d\b\26\1\2\u0133\u0134\7]\2\2\u0134"+
		"\u013d\b\26\1\2\u0135\u0136\7V\2\2\u0136\u013d\b\26\1\2\u0137\u0138\7"+
		"\\\2\2\u0138\u013d\b\26\1\2\u0139\u013a\5.\30\2\u013a\u013b\b\26\1\2\u013b"+
		"\u013d\3\2\2\2\u013c\u0130\3\2\2\2\u013c\u0131\3\2\2\2\u013c\u0133\3\2"+
		"\2\2\u013c\u0135\3\2\2\2\u013c\u0137\3\2\2\2\u013c\u0139\3\2\2\2\u013d"+
		"+\3\2\2\2\u013e\u014b\b\27\1\2\u013f\u0140\7\17\2\2\u0140\u014b\b\27\1"+
		"\2\u0141\u0142\7\20\2\2\u0142\u014b\b\27\1\2\u0143\u0144\7\21\2\2\u0144"+
		"\u014b\b\27\1\2\u0145\u0146\7g\2\2\u0146\u014b\b\27\1\2\u0147\u0148\5"+
		".\30\2\u0148\u0149\b\27\1\2\u0149\u014b\3\2\2\2\u014a\u013e\3\2\2\2\u014a"+
		"\u013f\3\2\2\2\u014a\u0141\3\2\2\2\u014a\u0143\3\2\2\2\u014a\u0145\3\2"+
		"\2\2\u014a\u0147\3\2\2\2\u014b-\3\2\2\2\u014c\u014d\7g\2\2\u014d\u014e"+
		"\7\22\2\2\u014e\u014f\5\60\31\2\u014f\u0150\b\30\1\2\u0150/\3\2\2\2\u0151"+
		"\u0152\7\21\2\2\u0152\u0156\b\31\1\2\u0153\u0154\7g\2\2\u0154\u0156\b"+
		"\31\1\2\u0155\u0151\3\2\2\2\u0155\u0153\3\2\2\2\u0156\61\3\2\2\2\u0157"+
		"\u0158\5\u0084C\2\u0158\u0159\b\32\1\2\u0159\63\3\2\2\2\u015a\u015b\5"+
		"\66\34\2\u015b\u015c\5h\65\2\u015c\u015d\5\64\33\2\u015d\u015e\b\33\1"+
		"\2\u015e\u0163\3\2\2\2\u015f\u0160\5\66\34\2\u0160\u0161\b\33\1\2\u0161"+
		"\u0163\3\2\2\2\u0162\u015a\3\2\2\2\u0162\u015f\3\2\2\2\u0163\65\3\2\2"+
		"\2\u0164\u0165\7:\2\2\u0165\u0166\7@\2\2\u0166\u0167\5l\67\2\u0167\u0168"+
		"\7\23\2\2\u0168\u0169\5\66\34\2\u0169\u016a\b\34\1\2\u016a\u0190\3\2\2"+
		"\2\u016b\u016c\7:\2\2\u016c\u016d\5l\67\2\u016d\u016e\7\23\2\2\u016e\u016f"+
		"\5\66\34\2\u016f\u0170\b\34\1\2\u0170\u0190\3\2\2\2\u0171\u0172\5p9\2"+
		"\u0172\u0173\7@\2\2\u0173\u0174\5l\67\2\u0174\u0175\7\23\2\2\u0175\u0176"+
		"\5\66\34\2\u0176\u0177\b\34\1\2\u0177\u0190\3\2\2\2\u0178\u0179\5p9\2"+
		"\u0179\u017a\5l\67\2\u017a\u017b\7\23\2\2\u017b\u017c\5\66\34\2\u017c"+
		"\u017d\b\34\1\2\u017d\u0190\3\2\2\2\u017e\u017f\7J\2\2\u017f\u0180\5\66"+
		"\34\2\u0180\u0181\7c\2\2\u0181\u0182\5\66\34\2\u0182\u0183\7A\2\2\u0183"+
		"\u0184\5\66\34\2\u0184\u0185\b\34\1\2\u0185\u0190\3\2\2\2\u0186\u0187"+
		"\7N\2\2\u0187\u0188\5n8\2\u0188\u0189\7K\2\2\u0189\u018a\5\66\34\2\u018a"+
		"\u018b\b\34\1\2\u018b\u0190\3\2\2\2\u018c\u018d\58\35\2\u018d\u018e\b"+
		"\34\1\2\u018e\u0190\3\2\2\2\u018f\u0164\3\2\2\2\u018f\u016b\3\2\2\2\u018f"+
		"\u0171\3\2\2\2\u018f\u0178\3\2\2\2\u018f\u017e\3\2\2\2\u018f\u0186\3\2"+
		"\2\2\u018f\u018c\3\2\2\2\u0190\67\3\2\2\2\u0191\u0192\7W\2\2\u0192\u0193"+
		"\5:\36\2\u0193\u0194\5j\66\2\u0194\u0195\b\35\1\2\u0195\u01bf\3\2\2\2"+
		"\u0196\u0197\7a\2\2\u0197\u0198\5:\36\2\u0198\u0199\5j\66\2\u0199\u019a"+
		"\b\35\1\2\u019a\u01bf\3\2\2\2\u019b\u019c\7O\2\2\u019c\u019d\5:\36\2\u019d"+
		"\u019e\5j\66\2\u019e\u019f\b\35\1\2\u019f\u01bf\3\2\2\2\u01a0\u01a1\7"+
		";\2\2\u01a1\u01a2\5:\36\2\u01a2\u01a3\5j\66\2\u01a3\u01a4\b\35\1\2\u01a4"+
		"\u01bf\3\2\2\2\u01a5\u01a6\5:\36\2\u01a6\u01a7\7U\2\2\u01a7\u01a8\7^\2"+
		"\2\u01a8\u01a9\5:\36\2\u01a9\u01aa\5j\66\2\u01aa\u01ab\b\35\1\2\u01ab"+
		"\u01bf\3\2\2\2\u01ac\u01ad\5:\36\2\u01ad\u01ae\7U\2\2\u01ae\u01af\7H\2"+
		"\2\u01af\u01b0\5:\36\2\u01b0\u01b1\5j\66\2\u01b1\u01b2\b\35\1\2\u01b2"+
		"\u01bf\3\2\2\2\u01b3\u01b4\7M\2\2\u01b4\u01b5\5:\36\2\u01b5\u01b6\b\35"+
		"\1\2\u01b6\u01bf\3\2\2\2\u01b7\u01b8\7E\2\2\u01b8\u01b9\5:\36\2\u01b9"+
		"\u01ba\b\35\1\2\u01ba\u01bf\3\2\2\2\u01bb\u01bc\5:\36\2\u01bc\u01bd\b"+
		"\35\1\2\u01bd\u01bf\3\2\2\2\u01be\u0191\3\2\2\2\u01be\u0196\3\2\2\2\u01be"+
		"\u019b\3\2\2\2\u01be\u01a0\3\2\2\2\u01be\u01a5\3\2\2\2\u01be\u01ac\3\2"+
		"\2\2\u01be\u01b3\3\2\2\2\u01be\u01b7\3\2\2\2\u01be\u01bb\3\2\2\2\u01bf"+
		"9\3\2\2\2\u01c0\u01c1\b\36\1\2\u01c1\u01c2\5<\37\2\u01c2\u01c3\b\36\1"+
		"\2\u01c3\u01cb\3\2\2\2\u01c4\u01c5\f\4\2\2\u01c5\u01c6\7\24\2\2\u01c6"+
		"\u01c7\5<\37\2\u01c7\u01c8\b\36\1\2\u01c8\u01ca\3\2\2\2\u01c9\u01c4\3"+
		"\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc"+
		";\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01cf\b\37\1\2\u01cf\u01d0\5> \2\u01d0"+
		"\u01d1\b\37\1\2\u01d1\u01d9\3\2\2\2\u01d2\u01d3\f\4\2\2\u01d3\u01d4\7"+
		"\25\2\2\u01d4\u01d5\5> \2\u01d5\u01d6\b\37\1\2\u01d6\u01d8\3\2\2\2\u01d7"+
		"\u01d2\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7\3\2\2\2\u01d9\u01da\3\2"+
		"\2\2\u01da=\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01dd\b \1\2\u01dd\u01de"+
		"\5@!\2\u01de\u01df\b \1\2\u01df\u01e7\3\2\2\2\u01e0\u01e1\f\4\2\2\u01e1"+
		"\u01e2\7\26\2\2\u01e2\u01e3\5@!\2\u01e3\u01e4\b \1\2\u01e4\u01e6\3\2\2"+
		"\2\u01e5\u01e0\3\2\2\2\u01e6\u01e9\3\2\2\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8"+
		"\3\2\2\2\u01e8?\3\2\2\2\u01e9\u01e7\3\2\2\2\u01ea\u01eb\b!\1\2\u01eb\u01ec"+
		"\5B\"\2\u01ec\u01ed\b!\1\2\u01ed\u01f5\3\2\2\2\u01ee\u01ef\f\4\2\2\u01ef"+
		"\u01f0\7f\2\2\u01f0\u01f1\5B\"\2\u01f1\u01f2\b!\1\2\u01f2\u01f4\3\2\2"+
		"\2\u01f3\u01ee\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5\u01f6"+
		"\3\2\2\2\u01f6A\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01f9\b\"\1\2\u01f9"+
		"\u01fa\5D#\2\u01fa\u01fb\b\"\1\2\u01fb\u0203\3\2\2\2\u01fc\u01fd\f\4\2"+
		"\2\u01fd\u01fe\7\27\2\2\u01fe\u01ff\5D#\2\u01ff\u0200\b\"\1\2\u0200\u0202"+
		"\3\2\2\2\u0201\u01fc\3\2\2\2\u0202\u0205\3\2\2\2\u0203\u0201\3\2\2\2\u0203"+
		"\u0204\3\2\2\2\u0204C\3\2\2\2\u0205\u0203\3\2\2\2\u0206\u0207\b#\1\2\u0207"+
		"\u0208\5F$\2\u0208\u0209\b#\1\2\u0209\u0216\3\2\2\2\u020a\u020b\f\5\2"+
		"\2\u020b\u020c\7\65\2\2\u020c\u020d\5F$\2\u020d\u020e\b#\1\2\u020e\u0215"+
		"\3\2\2\2\u020f\u0210\f\4\2\2\u0210\u0211\7d\2\2\u0211\u0212\5F$\2\u0212"+
		"\u0213\b#\1\2\u0213\u0215\3\2\2\2\u0214\u020a\3\2\2\2\u0214\u020f\3\2"+
		"\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0216\u0217\3\2\2\2\u0217"+
		"E\3\2\2\2\u0218\u0216\3\2\2\2\u0219\u021a\b$\1\2\u021a\u021b\5H%\2\u021b"+
		"\u021c\b$\1\2\u021c\u0229\3\2\2\2\u021d\u021e\f\5\2\2\u021e\u021f\7\66"+
		"\2\2\u021f\u0220\5H%\2\u0220\u0221\b$\1\2\u0221\u0228\3\2\2\2\u0222\u0223"+
		"\f\4\2\2\u0223\u0224\7e\2\2\u0224\u0225\5H%\2\u0225\u0226\b$\1\2\u0226"+
		"\u0228\3\2\2\2\u0227\u021d\3\2\2\2\u0227\u0222\3\2\2\2\u0228\u022b\3\2"+
		"\2\2\u0229\u0227\3\2\2\2\u0229\u022a\3\2\2\2\u022aG\3\2\2\2\u022b\u0229"+
		"\3\2\2\2\u022c\u022d\7\63\2\2\u022d\u022e\5H%\2\u022e\u022f\b%\1\2\u022f"+
		"\u0248\3\2\2\2\u0230\u0231\7C\2\2\u0231\u0232\5H%\2\u0232\u0233\b%\1\2"+
		"\u0233\u0248\3\2\2\2\u0234\u0235\7\64\2\2\u0235\u0236\5H%\2\u0236\u0237"+
		"\b%\1\2\u0237\u0248\3\2\2\2\u0238\u0239\7I\2\2\u0239\u023a\5H%\2\u023a"+
		"\u023b\b%\1\2\u023b\u0248\3\2\2\2\u023c\u023d\7\67\2\2\u023d\u023e\5H"+
		"%\2\u023e\u023f\b%\1\2\u023f\u0248\3\2\2\2\u0240\u0241\7X\2\2\u0241\u0242"+
		"\5H%\2\u0242\u0243\b%\1\2\u0243\u0248\3\2\2\2\u0244\u0245\5J&\2\u0245"+
		"\u0246\b%\1\2\u0246\u0248\3\2\2\2\u0247\u022c\3\2\2\2\u0247\u0230\3\2"+
		"\2\2\u0247\u0234\3\2\2\2\u0247\u0238\3\2\2\2\u0247\u023c\3\2\2\2\u0247"+
		"\u0240\3\2\2\2\u0247\u0244\3\2\2\2\u0248I\3\2\2\2\u0249\u024a\7\30\2\2"+
		"\u024a\u024b\5J&\2\u024b\u024c\b&\1\2\u024c\u0251\3\2\2\2\u024d\u024e"+
		"\5\u0086D\2\u024e\u024f\b&\1\2\u024f\u0251\3\2\2\2\u0250\u0249\3\2\2\2"+
		"\u0250\u024d\3\2\2\2\u0251K\3\2\2\2\u0252\u0253\b\'\1\2\u0253\u0254\5"+
		"N(\2\u0254\u0255\b\'\1\2\u0255\u0281\3\2\2\2\u0256\u0257\f\13\2\2\u0257"+
		"\u0258\7\31\2\2\u0258\u0259\5N(\2\u0259\u025a\b\'\1\2\u025a\u0280\3\2"+
		"\2\2\u025b\u025c\f\n\2\2\u025c\u025d\7\32\2\2\u025d\u025e\5N(\2\u025e"+
		"\u025f\b\'\1\2\u025f\u0280\3\2\2\2\u0260\u0261\f\t\2\2\u0261\u0262\7\3"+
		"\2\2\u0262\u0263\5N(\2\u0263\u0264\b\'\1\2\u0264\u0280\3\2\2\2\u0265\u0266"+
		"\f\b\2\2\u0266\u0267\7\33\2\2\u0267\u0268\5N(\2\u0268\u0269\b\'\1\2\u0269"+
		"\u0280\3\2\2\2\u026a\u026b\f\7\2\2\u026b\u026c\7\34\2\2\u026c\u026d\5"+
		"N(\2\u026d\u026e\b\'\1\2\u026e\u0280\3\2\2\2\u026f\u0270\f\6\2\2\u0270"+
		"\u0271\7\35\2\2\u0271\u0272\5N(\2\u0272\u0273\b\'\1\2\u0273\u0280\3\2"+
		"\2\2\u0274\u0275\f\5\2\2\u0275\u0276\7K\2\2\u0276\u0277\5N(\2\u0277\u0278"+
		"\b\'\1\2\u0278\u0280\3\2\2\2\u0279\u027a\f\4\2\2\u027a\u027b\7Z\2\2\u027b"+
		"\u027c\7K\2\2\u027c\u027d\5N(\2\u027d\u027e\b\'\1\2\u027e\u0280\3\2\2"+
		"\2\u027f\u0256\3\2\2\2\u027f\u025b\3\2\2\2\u027f\u0260\3\2\2\2\u027f\u0265"+
		"\3\2\2\2\u027f\u026a\3\2\2\2\u027f\u026f\3\2\2\2\u027f\u0274\3\2\2\2\u027f"+
		"\u0279\3\2\2\2\u0280\u0283\3\2\2\2\u0281\u027f\3\2\2\2\u0281\u0282\3\2"+
		"\2\2\u0282M\3\2\2\2\u0283\u0281\3\2\2\2\u0284\u0285\5p9\2\u0285\u0286"+
		"\5V,\2\u0286\u0287\b(\1\2\u0287\u028c\3\2\2\2\u0288\u0289\5P)\2\u0289"+
		"\u028a\b(\1\2\u028a\u028c\3\2\2\2\u028b\u0284\3\2\2\2\u028b\u0288\3\2"+
		"\2\2\u028cO\3\2\2\2\u028d\u028e\b)\1\2\u028e\u028f\5R*\2\u028f\u0290\b"+
		")\1\2\u0290\u029d\3\2\2\2\u0291\u0292\f\5\2\2\u0292\u0293\7\20\2\2\u0293"+
		"\u0294\5R*\2\u0294\u0295\b)\1\2\u0295\u029c\3\2\2\2\u0296\u0297\f\4\2"+
		"\2\u0297\u0298\7\36\2\2\u0298\u0299\5R*\2\u0299\u029a\b)\1\2\u029a\u029c"+
		"\3\2\2\2\u029b\u0291\3\2\2\2\u029b\u0296\3\2\2\2\u029c\u029f\3\2\2\2\u029d"+
		"\u029b\3\2\2\2\u029d\u029e\3\2\2\2\u029eQ\3\2\2\2\u029f\u029d\3\2\2\2"+
		"\u02a0\u02a1\b*\1\2\u02a1\u02a2\5T+\2\u02a2\u02a3\b*\1\2\u02a3\u02b5\3"+
		"\2\2\2\u02a4\u02a5\f\6\2\2\u02a5\u02a6\7\21\2\2\u02a6\u02a7\5T+\2\u02a7"+
		"\u02a8\b*\1\2\u02a8\u02b4\3\2\2\2\u02a9\u02aa\f\5\2\2\u02aa\u02ab\7\37"+
		"\2\2\u02ab\u02ac\5T+\2\u02ac\u02ad\b*\1\2\u02ad\u02b4\3\2\2\2\u02ae\u02af"+
		"\f\4\2\2\u02af\u02b0\7 \2\2\u02b0\u02b1\5T+\2\u02b1\u02b2\b*\1\2\u02b2"+
		"\u02b4\3\2\2\2\u02b3\u02a4\3\2\2\2\u02b3\u02a9\3\2\2\2\u02b3\u02ae\3\2"+
		"\2\2\u02b4\u02b7\3\2\2\2\u02b5\u02b3\3\2\2\2\u02b5\u02b6\3\2\2\2\u02b6"+
		"S\3\2\2\2\u02b7\u02b5\3\2\2\2\u02b8\u02b9\7Q\2\2\u02b9\u02ba\5V,\2\u02ba"+
		"\u02bb\b+\1\2\u02bb\u02c4\3\2\2\2\u02bc\u02bd\7S\2\2\u02bd\u02be\5V,\2"+
		"\u02be\u02bf\b+\1\2\u02bf\u02c4\3\2\2\2\u02c0\u02c1\5V,\2\u02c1\u02c2"+
		"\b+\1\2\u02c2\u02c4\3\2\2\2\u02c3\u02b8\3\2\2\2\u02c3\u02bc\3\2\2\2\u02c3"+
		"\u02c0\3\2\2\2\u02c4U\3\2\2\2\u02c5\u02c6\7b\2\2\u02c6\u02c7\5X-\2\u02c7"+
		"\u02c8\b,\1\2\u02c8\u02d9\3\2\2\2\u02c9\u02ca\7_\2\2\u02ca\u02cb\5X-\2"+
		"\u02cb\u02cc\b,\1\2\u02cc\u02d9\3\2\2\2\u02cd\u02ce\7!\2\2\u02ce\u02cf"+
		"\5X-\2\u02cf\u02d0\b,\1\2\u02d0\u02d9\3\2\2\2\u02d1\u02d2\7\36\2\2\u02d2"+
		"\u02d3\5X-\2\u02d3\u02d4\b,\1\2\u02d4\u02d9\3\2\2\2\u02d5\u02d6\5X-\2"+
		"\u02d6\u02d7\b,\1\2\u02d7\u02d9\3\2\2\2\u02d8\u02c5\3\2\2\2\u02d8\u02c9"+
		"\3\2\2\2\u02d8\u02cd\3\2\2\2\u02d8\u02d1\3\2\2\2\u02d8\u02d5\3\2\2\2\u02d9"+
		"W\3\2\2\2\u02da\u02db\b-\1\2\u02db\u02dc\5Z.\2\u02dc\u02dd\b-\1\2\u02dd"+
		"\u02e5\3\2\2\2\u02de\u02df\f\4\2\2\u02df\u02e0\7\"\2\2\u02e0\u02e1\5Z"+
		".\2\u02e1\u02e2\b-\1\2\u02e2\u02e4\3\2\2\2\u02e3\u02de\3\2\2\2\u02e4\u02e7"+
		"\3\2\2\2\u02e5\u02e3\3\2\2\2\u02e5\u02e6\3\2\2\2\u02e6Y\3\2\2\2\u02e7"+
		"\u02e5\3\2\2\2\u02e8\u02e9\b.\1\2\u02e9\u02ea\5\\/\2\u02ea\u02eb\b.\1"+
		"\2\u02eb\u02f3\3\2\2\2\u02ec\u02ed\f\4\2\2\u02ed\u02ee\7#\2\2\u02ee\u02ef"+
		"\5\\/\2\u02ef\u02f0\b.\1\2\u02f0\u02f2\3\2\2\2\u02f1\u02ec\3\2\2\2\u02f2"+
		"\u02f5\3\2\2\2\u02f3\u02f1\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4[\3\2\2\2"+
		"\u02f5\u02f3\3\2\2\2\u02f6\u02f7\b/\1\2\u02f7\u02f8\5^\60\2\u02f8\u02f9"+
		"\b/\1\2\u02f9\u0306\3\2\2\2\u02fa\u02fb\f\5\2\2\u02fb\u02fc\7$\2\2\u02fc"+
		"\u02fd\5^\60\2\u02fd\u02fe\b/\1\2\u02fe\u0305\3\2\2\2\u02ff\u0300\f\4"+
		"\2\2\u0300\u0301\7%\2\2\u0301\u0302\5^\60\2\u0302\u0303\b/\1\2\u0303\u0305"+
		"\3\2\2\2\u0304\u02fa\3\2\2\2\u0304\u02ff\3\2\2\2\u0305\u0308\3\2\2\2\u0306"+
		"\u0304\3\2\2\2\u0306\u0307\3\2\2\2\u0307]\3\2\2\2\u0308\u0306\3\2\2\2"+
		"\u0309\u030a\b\60\1\2\u030a\u030b\5`\61\2\u030b\u030c\b\60\1\2\u030c\u0314"+
		"\3\2\2\2\u030d\u030e\f\4\2\2\u030e\u030f\7&\2\2\u030f\u0310\5`\61\2\u0310"+
		"\u0311\b\60\1\2\u0311\u0313\3\2\2\2\u0312\u030d\3\2\2\2\u0313\u0316\3"+
		"\2\2\2\u0314\u0312\3\2\2\2\u0314\u0315\3\2\2\2\u0315_\3\2\2\2\u0316\u0314"+
		"\3\2\2\2\u0317\u0318\b\61\1\2\u0318\u0319\5b\62\2\u0319\u031a\b\61\1\2"+
		"\u031a\u0322\3\2\2\2\u031b\u031c\f\4\2\2\u031c\u031d\7\'\2\2\u031d\u031e"+
		"\5b\62\2\u031e\u031f\b\61\1\2\u031f\u0321\3\2\2\2\u0320\u031b\3\2\2\2"+
		"\u0321\u0324\3\2\2\2\u0322\u0320\3\2\2\2\u0322\u0323\3\2\2\2\u0323a\3"+
		"\2\2\2\u0324\u0322\3\2\2\2\u0325\u0326\b\62\1\2\u0326\u0327\5d\63\2\u0327"+
		"\u0328\b\62\1\2\u0328\u0335\3\2\2\2\u0329\u032a\f\5\2\2\u032a\u032b\7"+
		"(\2\2\u032b\u032c\5d\63\2\u032c\u032d\b\62\1\2\u032d\u0334\3\2\2\2\u032e"+
		"\u032f\f\4\2\2\u032f\u0330\7)\2\2\u0330\u0331\5d\63\2\u0331\u0332\b\62"+
		"\1\2\u0332\u0334\3\2\2\2\u0333\u0329\3\2\2\2\u0333\u032e\3\2\2\2\u0334"+
		"\u0337\3\2\2\2\u0335\u0333\3\2\2\2\u0335\u0336\3\2\2\2\u0336c\3\2\2\2"+
		"\u0337\u0335\3\2\2\2\u0338\u0339\5\62\32\2\u0339\u033a\b\63\1\2\u033a"+
		"\u0349\3\2\2\2\u033b\u033c\7g\2\2\u033c\u0349\b\63\1\2\u033d\u033e\7h"+
		"\2\2\u033e\u0349\b\63\1\2\u033f\u0340\7i\2\2\u0340\u0349\b\63\1\2\u0341"+
		"\u0342\7j\2\2\u0342\u0349\b\63\1\2\u0343\u0344\7\61\2\2\u0344\u0345\5"+
		"\64\33\2\u0345\u0346\7\62\2\2\u0346\u0347\b\63\1\2\u0347\u0349\3\2\2\2"+
		"\u0348\u0338\3\2\2\2\u0348\u033b\3\2\2\2\u0348\u033d\3\2\2\2\u0348\u033f"+
		"\3\2\2\2\u0348\u0341\3\2\2\2\u0348\u0343\3\2\2\2\u0349e\3\2\2\2\u034a"+
		"\u034b\5\66\34\2\u034b\u034c\b\64\1\2\u034cg\3\2\2\2\u034d\u034e\7*\2"+
		"\2\u034e\u035c\b\65\1\2\u034f\u0350\7+\2\2\u0350\u0351\5f\64\2\u0351\u0352"+
		"\7,\2\2\u0352\u0353\b\65\1\2\u0353\u035c\3\2\2\2\u0354\u0355\7-\2\2\u0355"+
		"\u035c\b\65\1\2\u0356\u0357\7+\2\2\u0357\u0358\5f\64\2\u0358\u0359\7."+
		"\2\2\u0359\u035a\b\65\1\2\u035a\u035c\3\2\2\2\u035b\u034d\3\2\2\2\u035b"+
		"\u034f\3\2\2\2\u035b\u0354\3\2\2\2\u035b\u0356\3\2\2\2\u035ci\3\2\2\2"+
		"\u035d\u035e\7>\2\2\u035e\u035f\5J&\2\u035f\u0360\b\66\1\2\u0360\u0373"+
		"\3\2\2\2\u0361\u0362\79\2\2\u0362\u0363\5J&\2\u0363\u0364\b\66\1\2\u0364"+
		"\u0373\3\2\2\2\u0365\u0366\7?\2\2\u0366\u0367\5J&\2\u0367\u0368\7<\2\2"+
		"\u0368\u0369\5J&\2\u0369\u036a\b\66\1\2\u036a\u0373\3\2\2\2\u036b\u036c"+
		"\79\2\2\u036c\u036d\5J&\2\u036d\u036e\7d\2\2\u036e\u036f\5J&\2\u036f\u0370"+
		"\b\66\1\2\u0370\u0373\3\2\2\2\u0371\u0373\b\66\1\2\u0372\u035d\3\2\2\2"+
		"\u0372\u0361\3\2\2\2\u0372\u0365\3\2\2\2\u0372\u036b\3\2\2\2\u0372\u0371"+
		"\3\2\2\2\u0373k\3\2\2\2\u0374\u0375\5\u0082B\2\u0375\u0376\7\13\2\2\u0376"+
		"\u0377\5X-\2\u0377\u0378\b\67\1\2\u0378m\3\2\2\2\u0379\u037a\5v<\2\u037a"+
		"\u037b\7\3\2\2\u037b\u037c\5\62\32\2\u037c\u037d\b8\1\2\u037do\3\2\2\2"+
		"\u037e\u037f\7Y\2\2\u037f\u0389\b9\1\2\u0380\u0381\7Z\2\2\u0381\u0389"+
		"\b9\1\2\u0382\u0383\7P\2\2\u0383\u0389\b9\1\2\u0384\u0385\7[\2\2\u0385"+
		"\u0389\b9\1\2\u0386\u0387\7`\2\2\u0387\u0389\b9\1\2\u0388\u037e\3\2\2"+
		"\2\u0388\u0380\3\2\2\2\u0388\u0382\3\2\2\2\u0388\u0384\3\2\2\2\u0388\u0386"+
		"\3\2\2\2\u0389q\3\2\2\2\u038a\u038b\7k\2\2\u038b\u038c\b:\1\2\u038cs\3"+
		"\2\2\2\u038d\u038e\7k\2\2\u038e\u038f\b;\1\2\u038fu\3\2\2\2\u0390\u0391"+
		"\7k\2\2\u0391\u0392\b<\1\2\u0392w\3\2\2\2\u0393\u0394\b=\1\2\u0394\u0395"+
		"\b=\1\2\u0395\u039c\3\2\2\2\u0396\u0397\f\3\2\2\u0397\u0398\5\16\b\2\u0398"+
		"\u0399\b=\1\2\u0399\u039b\3\2\2\2\u039a\u0396\3\2\2\2\u039b\u039e\3\2"+
		"\2\2\u039c\u039a\3\2\2\2\u039c\u039d\3\2\2\2\u039dy\3\2\2\2\u039e\u039c"+
		"\3\2\2\2\u039f\u03a0\5r:\2\u03a0\u03a1\b>\1\2\u03a1\u03a8\3\2\2\2\u03a2"+
		"\u03a3\5r:\2\u03a3\u03a4\7\23\2\2\u03a4\u03a5\5z>\2\u03a5\u03a6\b>\1\2"+
		"\u03a6\u03a8\3\2\2\2\u03a7\u039f\3\2\2\2\u03a7\u03a2\3\2\2\2\u03a8{\3"+
		"\2\2\2\u03a9\u03aa\b?\1\2\u03aa\u03ab\b?\1\2\u03ab\u03b2\3\2\2\2\u03ac"+
		"\u03ad\f\3\2\2\u03ad\u03ae\5 \21\2\u03ae\u03af\b?\1\2\u03af\u03b1\3\2"+
		"\2\2\u03b0\u03ac\3\2\2\2\u03b1\u03b4\3\2\2\2\u03b2\u03b0\3\2\2\2\u03b2"+
		"\u03b3\3\2\2\2\u03b3}\3\2\2\2\u03b4\u03b2\3\2\2\2\u03b5\u03b6\b@\1\2\u03b6"+
		"\u03b7\b@\1\2\u03b7\u03be\3\2\2\2\u03b8\u03b9\f\3\2\2\u03b9\u03ba\5\64"+
		"\33\2\u03ba\u03bb\b@\1\2\u03bb\u03bd\3\2\2\2\u03bc\u03b8\3\2\2\2\u03bd"+
		"\u03c0\3\2\2\2\u03be\u03bc\3\2\2\2\u03be\u03bf\3\2\2\2\u03bf\177\3\2\2"+
		"\2\u03c0\u03be\3\2\2\2\u03c1\u03c2\bA\1\2\u03c2\u03c3\bA\1\2\u03c3\u03ca"+
		"\3\2\2\2\u03c4\u03c5\f\3\2\2\u03c5\u03c6\5\30\r\2\u03c6\u03c7\bA\1\2\u03c7"+
		"\u03c9\3\2\2\2\u03c8\u03c4\3\2\2\2\u03c9\u03cc\3\2\2\2\u03ca\u03c8\3\2"+
		"\2\2\u03ca\u03cb\3\2\2\2\u03cb\u0081\3\2\2\2\u03cc\u03ca\3\2\2\2\u03cd"+
		"\u03ce\5v<\2\u03ce\u03cf\bB\1\2\u03cf\u03d6\3\2\2\2\u03d0\u03d1\5v<\2"+
		"\u03d1\u03d2\7/\2\2\u03d2\u03d3\5\u0082B\2\u03d3\u03d4\bB\1\2\u03d4\u03d6"+
		"\3\2\2\2\u03d5\u03cd\3\2\2\2\u03d5\u03d0\3\2\2\2\u03d6\u0083\3\2\2\2\u03d7"+
		"\u03d8\5t;\2\u03d8\u03d9\bC\1\2\u03d9\u03e0\3\2\2\2\u03da\u03db\5t;\2"+
		"\u03db\u03dc\7\60\2\2\u03dc\u03dd\5\u0084C\2\u03dd\u03de\bC\1\2\u03de"+
		"\u03e0\3\2\2\2\u03df\u03d7\3\2\2\2\u03df\u03da\3\2\2\2\u03e0\u0085\3\2"+
		"\2\2\u03e1\u03e2\5\u0088E\2\u03e2\u03e3\bD\1\2\u03e3\u0087\3\2\2\2\u03e4"+
		"\u03e5\5\u008aF\2\u03e5\u03e6\bE\1\2\u03e6\u0089\3\2\2\2\u03e7\u03e8\5"+
		"L\'\2\u03e8\u03e9\bF\1\2\u03e9\u008b\3\2\2\2:\u00ac\u00dd\u00e7\u00ee"+
		"\u00f3\u00fb\u010f\u0116\u0121\u0128\u012e\u013c\u014a\u0155\u0162\u018f"+
		"\u01be\u01cb\u01d9\u01e7\u01f5\u0203\u0214\u0216\u0227\u0229\u0247\u0250"+
		"\u027f\u0281\u028b\u029b\u029d\u02b3\u02b5\u02c3\u02d8\u02e5\u02f3\u0304"+
		"\u0306\u0314\u0322\u0333\u0335\u0348\u035b\u0372\u0388\u039c\u03a7\u03b2"+
		"\u03be\u03ca\u03d5\u03df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}