// Generated from clafer\claferParser.g4 by ANTLR 4.8
package clafer;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link claferParser}.
 */
public interface claferParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link claferParser#start_Module}.
	 * @param ctx the parse tree
	 */
	void enterStart_Module(claferParser.Start_ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#start_Module}.
	 * @param ctx the parse tree
	 */
	void exitStart_Module(claferParser.Start_ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#start_Clafer}.
	 * @param ctx the parse tree
	 */
	void enterStart_Clafer(claferParser.Start_ClaferContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#start_Clafer}.
	 * @param ctx the parse tree
	 */
	void exitStart_Clafer(claferParser.Start_ClaferContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#start_Constraint}.
	 * @param ctx the parse tree
	 */
	void enterStart_Constraint(claferParser.Start_ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#start_Constraint}.
	 * @param ctx the parse tree
	 */
	void exitStart_Constraint(claferParser.Start_ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#start_Assertion}.
	 * @param ctx the parse tree
	 */
	void enterStart_Assertion(claferParser.Start_AssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#start_Assertion}.
	 * @param ctx the parse tree
	 */
	void exitStart_Assertion(claferParser.Start_AssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#start_Goal}.
	 * @param ctx the parse tree
	 */
	void enterStart_Goal(claferParser.Start_GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#start_Goal}.
	 * @param ctx the parse tree
	 */
	void exitStart_Goal(claferParser.Start_GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(claferParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(claferParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(claferParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(claferParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#clafer}.
	 * @param ctx the parse tree
	 */
	void enterClafer(claferParser.ClaferContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#clafer}.
	 * @param ctx the parse tree
	 */
	void exitClafer(claferParser.ClaferContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(claferParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(claferParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#assertion}.
	 * @param ctx the parse tree
	 */
	void enterAssertion(claferParser.AssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#assertion}.
	 * @param ctx the parse tree
	 */
	void exitAssertion(claferParser.AssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(claferParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(claferParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#tempModifier}.
	 * @param ctx the parse tree
	 */
	void enterTempModifier(claferParser.TempModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#tempModifier}.
	 * @param ctx the parse tree
	 */
	void exitTempModifier(claferParser.TempModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#transition}.
	 * @param ctx the parse tree
	 */
	void enterTransition(claferParser.TransitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#transition}.
	 * @param ctx the parse tree
	 */
	void exitTransition(claferParser.TransitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#abstract_}.
	 * @param ctx the parse tree
	 */
	void enterAbstract_(claferParser.Abstract_Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#abstract_}.
	 * @param ctx the parse tree
	 */
	void exitAbstract_(claferParser.Abstract_Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#elements}.
	 * @param ctx the parse tree
	 */
	void enterElements(claferParser.ElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#elements}.
	 * @param ctx the parse tree
	 */
	void exitElements(claferParser.ElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(claferParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(claferParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#super_}.
	 * @param ctx the parse tree
	 */
	void enterSuper_(claferParser.Super_Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#super_}.
	 * @param ctx the parse tree
	 */
	void exitSuper_(claferParser.Super_Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(claferParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(claferParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(claferParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(claferParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#initHow}.
	 * @param ctx the parse tree
	 */
	void enterInitHow(claferParser.InitHowContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#initHow}.
	 * @param ctx the parse tree
	 */
	void exitInitHow(claferParser.InitHowContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#gCard}.
	 * @param ctx the parse tree
	 */
	void enterGCard(claferParser.GCardContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#gCard}.
	 * @param ctx the parse tree
	 */
	void exitGCard(claferParser.GCardContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#card}.
	 * @param ctx the parse tree
	 */
	void enterCard(claferParser.CardContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#card}.
	 * @param ctx the parse tree
	 */
	void exitCard(claferParser.CardContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#nCard}.
	 * @param ctx the parse tree
	 */
	void enterNCard(claferParser.NCardContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#nCard}.
	 * @param ctx the parse tree
	 */
	void exitNCard(claferParser.NCardContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exInteger}.
	 * @param ctx the parse tree
	 */
	void enterExInteger(claferParser.ExIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exInteger}.
	 * @param ctx the parse tree
	 */
	void exitExInteger(claferParser.ExIntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(claferParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(claferParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(claferParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(claferParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp1}.
	 * @param ctx the parse tree
	 */
	void enterExp1(claferParser.Exp1Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp1}.
	 * @param ctx the parse tree
	 */
	void exitExp1(claferParser.Exp1Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp2}.
	 * @param ctx the parse tree
	 */
	void enterExp2(claferParser.Exp2Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp2}.
	 * @param ctx the parse tree
	 */
	void exitExp2(claferParser.Exp2Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp3}.
	 * @param ctx the parse tree
	 */
	void enterExp3(claferParser.Exp3Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp3}.
	 * @param ctx the parse tree
	 */
	void exitExp3(claferParser.Exp3Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp4}.
	 * @param ctx the parse tree
	 */
	void enterExp4(claferParser.Exp4Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp4}.
	 * @param ctx the parse tree
	 */
	void exitExp4(claferParser.Exp4Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp5}.
	 * @param ctx the parse tree
	 */
	void enterExp5(claferParser.Exp5Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp5}.
	 * @param ctx the parse tree
	 */
	void exitExp5(claferParser.Exp5Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp6}.
	 * @param ctx the parse tree
	 */
	void enterExp6(claferParser.Exp6Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp6}.
	 * @param ctx the parse tree
	 */
	void exitExp6(claferParser.Exp6Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp7}.
	 * @param ctx the parse tree
	 */
	void enterExp7(claferParser.Exp7Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp7}.
	 * @param ctx the parse tree
	 */
	void exitExp7(claferParser.Exp7Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp8}.
	 * @param ctx the parse tree
	 */
	void enterExp8(claferParser.Exp8Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp8}.
	 * @param ctx the parse tree
	 */
	void exitExp8(claferParser.Exp8Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp9}.
	 * @param ctx the parse tree
	 */
	void enterExp9(claferParser.Exp9Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp9}.
	 * @param ctx the parse tree
	 */
	void exitExp9(claferParser.Exp9Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp10}.
	 * @param ctx the parse tree
	 */
	void enterExp10(claferParser.Exp10Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp10}.
	 * @param ctx the parse tree
	 */
	void exitExp10(claferParser.Exp10Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp11}.
	 * @param ctx the parse tree
	 */
	void enterExp11(claferParser.Exp11Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp11}.
	 * @param ctx the parse tree
	 */
	void exitExp11(claferParser.Exp11Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp15}.
	 * @param ctx the parse tree
	 */
	void enterExp15(claferParser.Exp15Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp15}.
	 * @param ctx the parse tree
	 */
	void exitExp15(claferParser.Exp15Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp16}.
	 * @param ctx the parse tree
	 */
	void enterExp16(claferParser.Exp16Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp16}.
	 * @param ctx the parse tree
	 */
	void exitExp16(claferParser.Exp16Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp17}.
	 * @param ctx the parse tree
	 */
	void enterExp17(claferParser.Exp17Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp17}.
	 * @param ctx the parse tree
	 */
	void exitExp17(claferParser.Exp17Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp18}.
	 * @param ctx the parse tree
	 */
	void enterExp18(claferParser.Exp18Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp18}.
	 * @param ctx the parse tree
	 */
	void exitExp18(claferParser.Exp18Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp19}.
	 * @param ctx the parse tree
	 */
	void enterExp19(claferParser.Exp19Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp19}.
	 * @param ctx the parse tree
	 */
	void exitExp19(claferParser.Exp19Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp20}.
	 * @param ctx the parse tree
	 */
	void enterExp20(claferParser.Exp20Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp20}.
	 * @param ctx the parse tree
	 */
	void exitExp20(claferParser.Exp20Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp21}.
	 * @param ctx the parse tree
	 */
	void enterExp21(claferParser.Exp21Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp21}.
	 * @param ctx the parse tree
	 */
	void exitExp21(claferParser.Exp21Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp22}.
	 * @param ctx the parse tree
	 */
	void enterExp22(claferParser.Exp22Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp22}.
	 * @param ctx the parse tree
	 */
	void exitExp22(claferParser.Exp22Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp23}.
	 * @param ctx the parse tree
	 */
	void enterExp23(claferParser.Exp23Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp23}.
	 * @param ctx the parse tree
	 */
	void exitExp23(claferParser.Exp23Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp24}.
	 * @param ctx the parse tree
	 */
	void enterExp24(claferParser.Exp24Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp24}.
	 * @param ctx the parse tree
	 */
	void exitExp24(claferParser.Exp24Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp25}.
	 * @param ctx the parse tree
	 */
	void enterExp25(claferParser.Exp25Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp25}.
	 * @param ctx the parse tree
	 */
	void exitExp25(claferParser.Exp25Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp26}.
	 * @param ctx the parse tree
	 */
	void enterExp26(claferParser.Exp26Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp26}.
	 * @param ctx the parse tree
	 */
	void exitExp26(claferParser.Exp26Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp27}.
	 * @param ctx the parse tree
	 */
	void enterExp27(claferParser.Exp27Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp27}.
	 * @param ctx the parse tree
	 */
	void exitExp27(claferParser.Exp27Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#transGuard}.
	 * @param ctx the parse tree
	 */
	void enterTransGuard(claferParser.TransGuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#transGuard}.
	 * @param ctx the parse tree
	 */
	void exitTransGuard(claferParser.TransGuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#transArrow}.
	 * @param ctx the parse tree
	 */
	void enterTransArrow(claferParser.TransArrowContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#transArrow}.
	 * @param ctx the parse tree
	 */
	void exitTransArrow(claferParser.TransArrowContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#patternScope}.
	 * @param ctx the parse tree
	 */
	void enterPatternScope(claferParser.PatternScopeContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#patternScope}.
	 * @param ctx the parse tree
	 */
	void exitPatternScope(claferParser.PatternScopeContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(claferParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(claferParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#varBinding}.
	 * @param ctx the parse tree
	 */
	void enterVarBinding(claferParser.VarBindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#varBinding}.
	 * @param ctx the parse tree
	 */
	void exitVarBinding(claferParser.VarBindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#quant}.
	 * @param ctx the parse tree
	 */
	void enterQuant(claferParser.QuantContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#quant}.
	 * @param ctx the parse tree
	 */
	void exitQuant(claferParser.QuantContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#enumId}.
	 * @param ctx the parse tree
	 */
	void enterEnumId(claferParser.EnumIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#enumId}.
	 * @param ctx the parse tree
	 */
	void exitEnumId(claferParser.EnumIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#modId}.
	 * @param ctx the parse tree
	 */
	void enterModId(claferParser.ModIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#modId}.
	 * @param ctx the parse tree
	 */
	void exitModId(claferParser.ModIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#locId}.
	 * @param ctx the parse tree
	 */
	void enterLocId(claferParser.LocIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#locId}.
	 * @param ctx the parse tree
	 */
	void exitLocId(claferParser.LocIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#listDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterListDeclaration(claferParser.ListDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#listDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitListDeclaration(claferParser.ListDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#listEnumId}.
	 * @param ctx the parse tree
	 */
	void enterListEnumId(claferParser.ListEnumIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#listEnumId}.
	 * @param ctx the parse tree
	 */
	void exitListEnumId(claferParser.ListEnumIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#listElement}.
	 * @param ctx the parse tree
	 */
	void enterListElement(claferParser.ListElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#listElement}.
	 * @param ctx the parse tree
	 */
	void exitListElement(claferParser.ListElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#listExp}.
	 * @param ctx the parse tree
	 */
	void enterListExp(claferParser.ListExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#listExp}.
	 * @param ctx the parse tree
	 */
	void exitListExp(claferParser.ListExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#listTempModifier}.
	 * @param ctx the parse tree
	 */
	void enterListTempModifier(claferParser.ListTempModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#listTempModifier}.
	 * @param ctx the parse tree
	 */
	void exitListTempModifier(claferParser.ListTempModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#listLocId}.
	 * @param ctx the parse tree
	 */
	void enterListLocId(claferParser.ListLocIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#listLocId}.
	 * @param ctx the parse tree
	 */
	void exitListLocId(claferParser.ListLocIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#listModId}.
	 * @param ctx the parse tree
	 */
	void enterListModId(claferParser.ListModIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#listModId}.
	 * @param ctx the parse tree
	 */
	void exitListModId(claferParser.ListModIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp12}.
	 * @param ctx the parse tree
	 */
	void enterExp12(claferParser.Exp12Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp12}.
	 * @param ctx the parse tree
	 */
	void exitExp12(claferParser.Exp12Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp13}.
	 * @param ctx the parse tree
	 */
	void enterExp13(claferParser.Exp13Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp13}.
	 * @param ctx the parse tree
	 */
	void exitExp13(claferParser.Exp13Context ctx);
	/**
	 * Enter a parse tree produced by {@link claferParser#exp14}.
	 * @param ctx the parse tree
	 */
	void enterExp14(claferParser.Exp14Context ctx);
	/**
	 * Exit a parse tree produced by {@link claferParser#exp14}.
	 * @param ctx the parse tree
	 */
	void exitExp14(claferParser.Exp14Context ctx);
}