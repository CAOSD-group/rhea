package rhea.parsers.clafer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import clafer.Absyn.Exp;
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
import clafer.Absyn.ClaferId;
import clafer.Absyn.EAnd;
import clafer.Absyn.EEq;
import clafer.Absyn.EGt;
import clafer.Absyn.EGte;
import clafer.Absyn.EIff;
import clafer.Absyn.EImplies;
import clafer.Absyn.EInt;
import clafer.Absyn.ELt;
import clafer.Absyn.ELte;
import clafer.Absyn.ENeq;
import clafer.Absyn.EOr;
import clafer.Absyn.EReal;
import clafer.Absyn.EXor;
import rhea.metamodels.BasicFMs.BasicFMsFactory;
import rhea.metamodels.BasicFMs.Feature;
import rhea.metamodels.BasicFMs.FeatureGroup;
import rhea.metamodels.BasicFMs.FeatureModel;
import rhea.metamodels.BasicFMs.impl.BasicFMsFactoryImpl;
import rhea.metamodels.CardinalityBasedFMs.CardinalityBasedFMsFactory;
import rhea.metamodels.CardinalityBasedFMs.GroupCardinality;
import rhea.metamodels.CardinalityBasedFMs.Multiplicity;
import rhea.metamodels.ComparativeCTCs.Equal;
import rhea.metamodels.ComparativeCTCs.Less;
import rhea.metamodels.ComparativeCTCs.LessOrEqual;
import rhea.metamodels.ComparativeCTCs.More;
import rhea.metamodels.ComparativeCTCs.MoreOrEqual;
import rhea.metamodels.ComparativeCTCs.NotEqual;
import rhea.metamodels.ComparativeCTCs.NumericTerm;
import rhea.metamodels.ComparativeCTCs.impl.ComparativeCTCsFactoryImpl;
import rhea.metamodels.DataTypes.DataType;
import rhea.metamodels.DataTypes.PrimitiveType;
import rhea.metamodels.DataTypes.PrimitiveTypeEnum;
import rhea.metamodels.DataTypes.impl.DataTypesFactoryImpl;
import rhea.metamodels.NumericalFMs.NumericalFeature;
import rhea.metamodels.NumericalFMs.impl.NumericalFMsFactoryImpl;
import rhea.metamodels.PropLogicCTCs.AdvancedConstraint;
import rhea.metamodels.PropLogicCTCs.And;
import rhea.metamodels.PropLogicCTCs.Equiv;
import rhea.metamodels.PropLogicCTCs.FeatureTerm;
import rhea.metamodels.PropLogicCTCs.Implies;
import rhea.metamodels.PropLogicCTCs.Or;
import rhea.metamodels.PropLogicCTCs.Term;
import rhea.metamodels.PropLogicCTCs.Xor;
import rhea.metamodels.PropLogicCTCs.impl.PropLogicCTCsFactoryImpl;

public class MyClaferParserListener implements claferParserListener {
	private FeatureModel fm;
	private Feature currentFeature;
	private AdvancedConstraint currentConstraint;
	private boolean operatedConstraint;
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
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitStart_Module(Start_ModuleContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterStart_Clafer(Start_ClaferContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitStart_Clafer(Start_ClaferContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterStart_Constraint(Start_ConstraintContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitStart_Constraint(Start_ConstraintContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterStart_Assertion(Start_AssertionContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitStart_Assertion(Start_AssertionContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterStart_Goal(Start_GoalContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitStart_Goal(Start_GoalContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterModule(ModuleContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitModule(ModuleContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterDeclaration(DeclarationContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitDeclaration(DeclarationContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
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
		operatedConstraint = false;
		
		if(currentConstraint!=null) fm.getCrosstreeconstraints().add(currentConstraint);
		
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
				currentFeature.setId(featureName);
				currentFeature.setAbstract(true);
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
					currentFeature.setId(featureName);
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
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitConstraint(ConstraintContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterAssertion(AssertionContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitAssertion(AssertionContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterGoal(GoalContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitGoal(GoalContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterTempModifier(TempModifierContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitTempModifier(TempModifierContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterTransition(TransitionContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitTransition(TransitionContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterAbstract_(Abstract_Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitAbstract_(Abstract_Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterElements(ElementsContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitElements(ElementsContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterElement(ElementContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitElement(ElementContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterSuper_(Super_Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitSuper_(Super_Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterReference(ReferenceContext ctx) {
		// No lo reconoce como feature numérica, sino como referencia a un conjunto
		String type = ctx.getText();
	
		if(type.contains("->")) {
			// format [->,type]
			String nf = ctx.getText().substring(2);	
			currentFeature = NumericalFMsFactoryImpl.eINSTANCE.createNumericalFeature();
			DataType dt = DataTypesFactoryImpl.eINSTANCE.createPrimitiveType();
			
			if(nf.equals("Integer")) ((PrimitiveType)dt).setType(PrimitiveTypeEnum.INTEGER);
			else if(nf.equals("Natural")) ((PrimitiveType)dt).setType(PrimitiveTypeEnum.NATURAL);
			else if(nf.equals("Real")) ((PrimitiveType)dt).setType(PrimitiveTypeEnum.REAL);
			
			//Set the type
			((NumericalFeature) currentFeature).setType(dt);
			
			//No le llega el valor de la Feature Numerica 
			//Set the value TODO
		}
	}

	@Override
	public void exitReference(ReferenceContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterInit(InitContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitInit(InitContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterInitHow(InitHowContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitInitHow(InitHowContext ctx) {
		// TODO Auto-generated method stub
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
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
		case "mux":
			currentFeature = CardinalityBasedFMsFactory.eINSTANCE.createMutexGroup();
		}
		if (type.contains("..")) {
			currentFeature = CardinalityBasedFMsFactory.eINSTANCE.createGroupCardinality();
			int lower = Integer.parseInt(type.substring(0, type.indexOf(".")));
			String upperMult = type.substring(type.lastIndexOf(".")+1, type.length());
			int upper = upperMult.equals("*") ? -1 : Integer.parseInt(upperMult); 
			Multiplicity mul = CardinalityBasedFMsFactory.eINSTANCE.createMultiplicity();
			mul.setLower(lower);
			mul.setUpper(upper);
			((GroupCardinality) currentFeature).setMultiplicity(mul);
		}
	}

	@Override
	public void exitGCard(GCardContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
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
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterNCard(NCardContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitNCard(NCardContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExInteger(ExIntegerContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExInteger(ExIntegerContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterName(NameContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitName(NameContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}


	@Override
	public void enterExp(ExpContext ctx) {
		// Triggers on each operator in the contraints
		if (!operatedConstraint)
		{
			currentConstraint = PropLogicCTCsFactoryImpl.eINSTANCE.createAdvancedConstraint();
			operatedConstraint = true;
			currentConstraint.setExpr(parserConstraint(ctx.result));
		}
	}

	@Override
	public void exitExp(ExpContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp1(Exp1Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp1(Exp1Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp2(Exp2Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp2(Exp2Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp3(Exp3Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp3(Exp3Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp4(Exp4Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp4(Exp4Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp5(Exp5Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp5(Exp5Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp6(Exp6Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp6(Exp6Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp7(Exp7Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp7(Exp7Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp8(Exp8Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp8(Exp8Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp9(Exp9Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp9(Exp9Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp10(Exp10Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp10(Exp10Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp11(Exp11Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp11(Exp11Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp15(Exp15Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp15(Exp15Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp16(Exp16Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp16(Exp16Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp17(Exp17Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp17(Exp17Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp18(Exp18Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp18(Exp18Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp19(Exp19Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp19(Exp19Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp20(Exp20Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp20(Exp20Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp21(Exp21Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp21(Exp21Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp22(Exp22Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp22(Exp22Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp23(Exp23Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp23(Exp23Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp24(Exp24Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp24(Exp24Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp25(Exp25Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp25(Exp25Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp26(Exp26Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp26(Exp26Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp27(Exp27Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp27(Exp27Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterTransGuard(TransGuardContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitTransGuard(TransGuardContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterTransArrow(TransArrowContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitTransArrow(TransArrowContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterPatternScope(PatternScopeContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitPatternScope(PatternScopeContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterDecl(DeclContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitDecl(DeclContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterVarBinding(VarBindingContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitVarBinding(VarBindingContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterQuant(QuantContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitQuant(QuantContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterEnumId(EnumIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitEnumId(EnumIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterModId(ModIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitModId(ModIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterLocId(LocIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitLocId(LocIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterListDeclaration(ListDeclarationContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitListDeclaration(ListDeclarationContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterListEnumId(ListEnumIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitListEnumId(ListEnumIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterListElement(ListElementContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitListElement(ListElementContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterListExp(ListExpContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitListExp(ListExpContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterListTempModifier(ListTempModifierContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitListTempModifier(ListTempModifierContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterListLocId(ListLocIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitListLocId(ListLocIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterListModId(ListModIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitListModId(ListModIdContext ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp12(Exp12Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp12(Exp12Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp13(Exp13Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp13(Exp13Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void enterExp14(Exp14Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}

	@Override
	public void exitExp14(Exp14Context ctx) {
		//System.out.println(new Object(){}.getClass().getEnclosingMethod().getName() + " " + ctx.getText());
	}
	
	private Term parserConstraint(Exp exp) {
		Term t = null;
		
		if(exp instanceof EImplies)
		{
			// => Requires or Implies
			t = PropLogicCTCsFactoryImpl.eINSTANCE.createImplies();
			((Implies) t).setLeft(parserConstraint(((EImplies) exp).exp_1));
			((Implies) t).setRight(parserConstraint(((EImplies) exp).exp_2));
		}
		
		/*
		else if(exp instanceof EExcludes)
		{

		}
		*/
		
		else if(exp instanceof ELt)
		{
			// <
			t = ComparativeCTCsFactoryImpl.eINSTANCE.createLess();
			((Less) t).setLeft(parserConstraint(((ELt) exp).exp_1));
			((Less) t).setRight(parserConstraint(((ELt) exp).exp_2));
		}
		else if(exp instanceof EGt)
		{
			// >
			t = ComparativeCTCsFactoryImpl.eINSTANCE.createMore();
			((More) t).setLeft(parserConstraint(((EGt) exp).exp_1));
			((More) t).setRight(parserConstraint(((EGt) exp).exp_2));
		}
		else if(exp instanceof ELte)
		{
			// <=
			t = ComparativeCTCsFactoryImpl.eINSTANCE.createLessOrEqual();
			((LessOrEqual) t).setLeft(parserConstraint(((ELte) exp).exp_1));
			((LessOrEqual) t).setRight(parserConstraint(((ELte) exp).exp_2));
		}
		else if(exp instanceof EGte)
		{
			// >=
			t = ComparativeCTCsFactoryImpl.eINSTANCE.createMoreOrEqual();
			((MoreOrEqual) t).setLeft(parserConstraint(((EGte) exp).exp_1));
			((MoreOrEqual) t).setRight(parserConstraint(((EGte) exp).exp_2));
		}
		else if(exp instanceof ENeq)
		{
			// !=
			t = ComparativeCTCsFactoryImpl.eINSTANCE.createNotEqual();
			((NotEqual) t).setLeft(parserConstraint(((ENeq) exp).exp_1));
			((NotEqual) t).setRight(parserConstraint(((ENeq) exp).exp_2));
		}
		else if(exp instanceof EEq)
		{
			// =
			t = ComparativeCTCsFactoryImpl.eINSTANCE.createEqual();
			((Equal) t).setLeft(parserConstraint(((EEq) exp).exp_1));
			((Equal) t).setRight(parserConstraint(((EEq) exp).exp_2));
		}
		else if(exp instanceof EAnd) 
		{
			// &&
			t = PropLogicCTCsFactoryImpl.eINSTANCE.createAnd();
			List<Term> terms = ((And) t).getTerms();
			
			terms.add(parserConstraint(((EAnd) exp).exp_1));
			terms.add(parserConstraint(((EAnd) exp).exp_2));
			
			/* REVISAR OR Y ANDS, COMPROBAR SI LO QUE ESTA ESCRITO ES EQUIVALENTE A UN ÚNICO AND (LO QUE ESTA COMENTADO PERO NO ACABADO) TODO
			if (((EAnd) exp).exp_1 instanceof EAnd)
			{
				terms.add(parserConstraint(((EAnd) exp).exp_1));
				
			}
			
			if (((EAnd) exp).exp_2 instanceof EAnd)
			{
				terms.add(parserConstraint(((EAnd) exp).exp_2));
			}
			*/
			
		}
		else if(exp instanceof EOr)
		{
			// ||
			t = PropLogicCTCsFactoryImpl.eINSTANCE.createOr();
			List<Term> terms = ((Or) t).getTerms();
			
			terms.add(parserConstraint(((EOr) exp).exp_1));
			terms.add(parserConstraint(((EOr) exp).exp_2));
			
		}
		else if(exp instanceof EXor)
			// xor
		{
			t = PropLogicCTCsFactoryImpl.eINSTANCE.createXor();
			List<Term> terms = ((Xor) t).getTerms();
			
			terms.add(parserConstraint(((EXor) exp).exp_1));
			terms.add(parserConstraint(((EXor) exp).exp_2));
		}
		else if(exp instanceof EIff)
		{
			// <=>
			t = PropLogicCTCsFactoryImpl.eINSTANCE.createEquiv();
			List<Term> terms = ((And) t).getTerms();
			
			terms.add(parserConstraint(((EIff) exp).exp_1));
			terms.add(parserConstraint(((EIff) exp).exp_2));
		}
		else if(exp instanceof ClaferId)
		{
			t = PropLogicCTCsFactoryImpl.eINSTANCE.createFeatureTerm();
			//((FeatureTerm) t).setFeature(fm.getFeature(((ClaferId) exp).name_.toString())); // Como obtengo la feature TODO
			((FeatureTerm) t).setFeature(BasicFMsFactoryImpl.eINSTANCE.createFeature());
		}
		else if(exp instanceof EInt)
		{
			t = ComparativeCTCsFactoryImpl.eINSTANCE.createNumericTerm();
			((NumericTerm) t).setValue(Integer.parseInt(((EInt) exp).posinteger_));
		}
		else if(exp instanceof EReal)
		{
			t = ComparativeCTCsFactoryImpl.eINSTANCE.createNumericTerm();
			((NumericTerm) t).setValue(Float.parseFloat(((EReal) exp).posreal_));
		}
		
		return t;
	}
}
