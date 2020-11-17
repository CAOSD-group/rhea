package rhea.parsers.clafer;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import clafer.claferParser.Abstract_Context;
import clafer.claferParser.AssertionContext;
import clafer.claferParser.CardContext;
import clafer.claferParser.ClaferContext;
import clafer.claferParser.ConstraintContext;
import clafer.claferParser.DeclContext;
import clafer.claferParser.DeclarationContext;
import clafer.claferParser.ElementContext;
import clafer.claferParser.ElementsContext;
import clafer.claferParser.EnumIdContext;
import clafer.claferParser.ExIntegerContext;
import clafer.claferParser.Exp10Context;
import clafer.claferParser.Exp11Context;
import clafer.claferParser.Exp12Context;
import clafer.claferParser.Exp13Context;
import clafer.claferParser.Exp14Context;
import clafer.claferParser.Exp15Context;
import clafer.claferParser.Exp16Context;
import clafer.claferParser.Exp17Context;
import clafer.claferParser.Exp18Context;
import clafer.claferParser.Exp19Context;
import clafer.claferParser.Exp1Context;
import clafer.claferParser.Exp20Context;
import clafer.claferParser.Exp21Context;
import clafer.claferParser.Exp22Context;
import clafer.claferParser.Exp23Context;
import clafer.claferParser.Exp24Context;
import clafer.claferParser.Exp25Context;
import clafer.claferParser.Exp26Context;
import clafer.claferParser.Exp27Context;
import clafer.claferParser.Exp2Context;
import clafer.claferParser.Exp3Context;
import clafer.claferParser.Exp4Context;
import clafer.claferParser.Exp5Context;
import clafer.claferParser.Exp6Context;
import clafer.claferParser.Exp7Context;
import clafer.claferParser.Exp8Context;
import clafer.claferParser.Exp9Context;
import clafer.claferParser.ExpContext;
import clafer.claferParser.GCardContext;
import clafer.claferParser.GoalContext;
import clafer.claferParser.InitContext;
import clafer.claferParser.InitHowContext;
import clafer.claferParser.ListDeclarationContext;
import clafer.claferParser.ListElementContext;
import clafer.claferParser.ListEnumIdContext;
import clafer.claferParser.ListExpContext;
import clafer.claferParser.ListLocIdContext;
import clafer.claferParser.ListModIdContext;
import clafer.claferParser.ListTempModifierContext;
import clafer.claferParser.LocIdContext;
import clafer.claferParser.ModIdContext;
import clafer.claferParser.ModuleContext;
import clafer.claferParser.NCardContext;
import clafer.claferParser.NameContext;
import clafer.claferParser.PatternScopeContext;
import clafer.claferParser.QuantContext;
import clafer.claferParser.ReferenceContext;
import clafer.claferParser.Start_AssertionContext;
import clafer.claferParser.Start_ClaferContext;
import clafer.claferParser.Start_ConstraintContext;
import clafer.claferParser.Start_GoalContext;
import clafer.claferParser.Start_ModuleContext;
import clafer.claferParser.Super_Context;
import clafer.claferParser.TempModifierContext;
import clafer.claferParser.TransArrowContext;
import clafer.claferParser.TransGuardContext;
import clafer.claferParser.TransitionContext;
import clafer.claferParser.VarBindingContext;
import clafer.claferParserListener;
import rhea.metamodels.BasicFMs.BasicFMsFactory;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureGroup;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsFactory;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.CardinalityBasedFMs.Multiplicity;

public class MyClaferParserListener implements claferParserListener {
	private FeatureModel fm;
	private Feature currentFeature;
	private Boolean mandatory;
	private int nFeatures;
	private boolean isValidFeature;
	private Map<Integer, Integer> indentations;
	private Map<Integer, Feature> indentParent;
	
	
	public MyClaferParserListener(Map<Integer, Integer> indentations) {
		this.indentations = indentations;
		this.indentParent = new HashMap<Integer, Feature>();
		this.indentParent.put(0, null);
		
		fm = BasicFMsFactory.eINSTANCE.createFeatureModel();
		nFeatures = 0;
	}
	
	public FeatureModel getFeatureModel() {
		return fm;
	}
	
	public int getFeatures() {
		return nFeatures;
	}

	
	@Override
	public void enterEveryRule(ParserRuleContext arg0) {
		
	}

	@Override
	public void exitEveryRule(ParserRuleContext arg0) {
		
	}

	@Override
	public void visitErrorNode(ErrorNode arg0) {
		

	}

	@Override
	public void visitTerminal(TerminalNode arg0) {
		
	}

	@Override
	public void enterStart_Module(Start_ModuleContext ctx) {
		
	}

	@Override
	public void exitStart_Module(Start_ModuleContext ctx) {
		
	}

	@Override
	public void enterStart_Clafer(Start_ClaferContext ctx) {
		
	}

	@Override
	public void exitStart_Clafer(Start_ClaferContext ctx) {
		
	}

	@Override
	public void enterStart_Constraint(Start_ConstraintContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitStart_Constraint(Start_ConstraintContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterStart_Assertion(Start_AssertionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitStart_Assertion(Start_AssertionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterStart_Goal(Start_GoalContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitStart_Goal(Start_GoalContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterModule(ModuleContext ctx) {
		/*
		System.out.println("Module: " + ctx.getText());
		System.out.println("    depth: " + ctx.depth());
		System.out.println("    getAltNumber: " + ctx.getAltNumber());
		System.out.println("    getRuleIndex: " + ctx.getRuleIndex());
		System.out.println("    getChildCount: " + ctx.getChildCount());
		System.out.println("    getChild: " + ctx.getChild(0));
		*/
	}

	@Override
	public void exitModule(ModuleContext ctx) {
		
	}

	@Override
	public void enterDeclaration(DeclarationContext ctx) {
		
	}

	@Override
	public void exitDeclaration(DeclarationContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterClafer(ClaferContext ctx) {
		currentFeature = null;
		mandatory = true;
		isValidFeature = true;
		if (fm.getRoot() != null && this.indentations.get(nFeatures) == 0) {
			isValidFeature = false;
		}
	}

	@Override
	public void exitClafer(ClaferContext ctx) {
		if (isValidFeature) {
			// Create simple feature if not has been created (e.g., because of a group)
			if (currentFeature == null) 
				currentFeature = BasicFMsFactory.eINSTANCE.createFeature();
			
			// Set feature name
			String featureName = ctx.getChild(3).getText();
			currentFeature.setName(featureName);
			
			// Set mandatory/optional
			currentFeature.setMandatory(mandatory);
			
			// Set root feature
			if (nFeatures == 0) {
				fm.setRoot(currentFeature);
				this.indentParent.put(1, currentFeature);
			} else {
				// Set parent feature
				int indent = this.indentations.get(nFeatures);
				//System.out.println(indent);
				Feature parent = this.indentParent.get(indent);
				//System.out.println("Feature -> parent: " + featureName + " -> " + parent);
				this.indentParent.put(indent+1, currentFeature);
				
				if (parent != null) {
					parent.getChildren().add(currentFeature);
					if (parent instanceof FeatureGroup) {		// BE CAREFUL! we do not allow mandatory feature inside a group, but we should?
						currentFeature.setMandatory(false);
					}
				}
				currentFeature.setParent(parent);
			}
			
			fm.getFeatures().add(currentFeature);
		}
		nFeatures++;
		
	}

	@Override
	public void enterConstraint(ConstraintContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitConstraint(ConstraintContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterAssertion(AssertionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitAssertion(AssertionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterGoal(GoalContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitGoal(GoalContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTempModifier(TempModifierContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTempModifier(TempModifierContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTransition(TransitionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitTransition(TransitionContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterAbstract_(Abstract_Context ctx) {
		//System.out.println("Abstract: " + ctx.getText());
	}

	@Override
	public void exitAbstract_(Abstract_Context ctx) {

	}

	@Override
	public void enterElements(ElementsContext ctx) {

	}

	@Override
	public void exitElements(ElementsContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterElement(ElementContext ctx) {

	}

	@Override
	public void exitElement(ElementContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterSuper_(Super_Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitSuper_(Super_Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterReference(ReferenceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitReference(ReferenceContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterInit(InitContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitInit(InitContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterInitHow(InitHowContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitInitHow(InitHowContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterGCard(GCardContext ctx) {
		String type = ctx.getText();
		switch (type) {
		case "xor":
			currentFeature = BasicFMsFactory.eINSTANCE.createAlternativeGroup();
			break;
		case "or":
			currentFeature = BasicFMsFactory.eINSTANCE.createSelectionGroup();
			break;
		}
		if (type.contains("..")) {
			currentFeature = CardinalityBasedFMsFactory.eINSTANCE.createGroupCardinality();
			int lower = Integer.parseInt(type.substring(0, type.indexOf(".")));
			int upper = Integer.parseInt(type.substring(type.lastIndexOf(".")+1, type.length()));
			Multiplicity mul = CardinalityBasedFMsFactory.eINSTANCE.createMultiplicity();
			mul.setLower(lower);
			mul.setUpper(upper);
			((GroupCardinality) currentFeature).setMultiplicity(mul);
		}
	}

	@Override
	public void exitGCard(GCardContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterCard(CardContext ctx) {
		String type = ctx.getText();
		switch (type) {
		case "?":
			mandatory = false;
			break;
		}
	}

	@Override
	public void exitCard(CardContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterNCard(NCardContext ctx) {

	}

	@Override
	public void exitNCard(NCardContext ctx) {

	}

	@Override
	public void enterExInteger(ExIntegerContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExInteger(ExIntegerContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterName(NameContext ctx) {
		
	}

	@Override
	public void exitName(NameContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp(ExpContext ctx) {
		
	}

	@Override
	public void exitExp(ExpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp1(Exp1Context ctx) {
		
	}

	@Override
	public void exitExp1(Exp1Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp2(Exp2Context ctx) {
		
	}

	@Override
	public void exitExp2(Exp2Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp3(Exp3Context ctx) {
		
	}

	@Override
	public void exitExp3(Exp3Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp4(Exp4Context ctx) {
		
	}

	@Override
	public void exitExp4(Exp4Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp5(Exp5Context ctx) {
		
	}

	@Override
	public void exitExp5(Exp5Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp6(Exp6Context ctx) {
		
	}

	@Override
	public void exitExp6(Exp6Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp7(Exp7Context ctx) {
		
	}

	@Override
	public void exitExp7(Exp7Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp8(Exp8Context ctx) {
		
	}

	@Override
	public void exitExp8(Exp8Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp9(Exp9Context ctx) {
		
	}

	@Override
	public void exitExp9(Exp9Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp10(Exp10Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp10(Exp10Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp11(Exp11Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp11(Exp11Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp15(Exp15Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp15(Exp15Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp16(Exp16Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp16(Exp16Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp17(Exp17Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp17(Exp17Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp18(Exp18Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp18(Exp18Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp19(Exp19Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp19(Exp19Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp20(Exp20Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp20(Exp20Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp21(Exp21Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp21(Exp21Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp22(Exp22Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp22(Exp22Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp23(Exp23Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp23(Exp23Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp24(Exp24Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp24(Exp24Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp25(Exp25Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp25(Exp25Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp26(Exp26Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp26(Exp26Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp27(Exp27Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp27(Exp27Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTransGuard(TransGuardContext ctx) {
		
	}

	@Override
	public void exitTransGuard(TransGuardContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterTransArrow(TransArrowContext ctx) {
		
	}

	@Override
	public void exitTransArrow(TransArrowContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterPatternScope(PatternScopeContext ctx) {
		
	}

	@Override
	public void exitPatternScope(PatternScopeContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterDecl(DeclContext ctx) {
		
	}

	@Override
	public void exitDecl(DeclContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterVarBinding(VarBindingContext ctx) {
		
	}

	@Override
	public void exitVarBinding(VarBindingContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterQuant(QuantContext ctx) {
		
	}

	@Override
	public void exitQuant(QuantContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterEnumId(EnumIdContext ctx) {
		
	}

	@Override
	public void exitEnumId(EnumIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterModId(ModIdContext ctx) {
		
	}

	@Override
	public void exitModId(ModIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterLocId(LocIdContext ctx) {
		
	}

	@Override
	public void exitLocId(LocIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterListDeclaration(ListDeclarationContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitListDeclaration(ListDeclarationContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterListEnumId(ListEnumIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitListEnumId(ListEnumIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterListElement(ListElementContext ctx) {
		
	}

	@Override
	public void exitListElement(ListElementContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterListExp(ListExpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitListExp(ListExpContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterListTempModifier(ListTempModifierContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitListTempModifier(ListTempModifierContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterListLocId(ListLocIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitListLocId(ListLocIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterListModId(ListModIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitListModId(ListModIdContext ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp12(Exp12Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp12(Exp12Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp13(Exp13Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void exitExp13(Exp13Context ctx) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enterExp14(Exp14Context ctx) {
		
	}

	@Override
	public void exitExp14(Exp14Context ctx) {
		
	}

}
