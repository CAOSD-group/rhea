defaultScope(1);
intRange(-8, 7);
stringLength(16);

c0_Root = Abstract("c0_Root");
c0_A = c0_Root.addChild("c0_A").withCard(1, 1).withGroupCard(1);
c0_A1 = c0_A.addChild("c0_A1").withCard(0, 1);
c0_A2 = c0_A.addChild("c0_A2").withCard(0, 1);
c0_A3 = c0_A.addChild("c0_A3").withCard(0, 1);
c0_config = Clafer("c0_config").withCard(1, 1);
Constraint(implies(some(join(global(c0_Root), c0_A)), or(or(or(or(or(or(and(and(none(join(join(global(c0_Root), c0_A), c0_A1)), none(join(join(global(c0_Root), c0_A), c0_A2))), some(join(join(global(c0_Root), c0_A), c0_A3))), and(and(none(join(join(global(c0_Root), c0_A), c0_A1)), some(join(join(global(c0_Root), c0_A), c0_A2))), none(join(join(global(c0_Root), c0_A), c0_A3)))), and(and(none(join(join(global(c0_Root), c0_A), c0_A1)), some(join(join(global(c0_Root), c0_A), c0_A2))), some(join(join(global(c0_Root), c0_A), c0_A3)))), and(and(some(join(join(global(c0_Root), c0_A), c0_A1)), none(join(join(global(c0_Root), c0_A), c0_A2))), none(join(join(global(c0_Root), c0_A), c0_A3)))), and(and(some(join(join(global(c0_Root), c0_A), c0_A1)), none(join(join(global(c0_Root), c0_A), c0_A2))), some(join(join(global(c0_Root), c0_A), c0_A3)))), and(and(some(join(join(global(c0_Root), c0_A), c0_A1)), some(join(join(global(c0_Root), c0_A), c0_A2))), none(join(join(global(c0_Root), c0_A), c0_A3)))), and(and(some(join(join(global(c0_Root), c0_A), c0_A1)), some(join(join(global(c0_Root), c0_A), c0_A2))), some(join(join(global(c0_Root), c0_A), c0_A3))))));
c0_config.extending(c0_Root);
