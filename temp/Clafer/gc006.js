defaultScope(1);
intRange(-8, 7);
stringLength(16);

c0_Root = Abstract("c0_Root");
c0_B = c0_Root.addChild("c0_B").withCard(1, 1).withGroupCard(1, 1);
c0_B3 = c0_B.addChild("c0_B3").withCard(0, 1);
c0_B1 = c0_B.addChild("c0_B1").withCard(0, 1);
c0_B2 = c0_B.addChild("c0_B2").withCard(0, 1);
c0_A = c0_Root.addChild("c0_A").withCard(1, 1).withGroupCard(1, 1);
c0_A1 = c0_A.addChild("c0_A1").withCard(0, 1);
c0_A2 = c0_A.addChild("c0_A2").withCard(0, 1);
c0_A3 = c0_A.addChild("c0_A3").withCard(0, 1);
c0_config = Clafer("c0_config").withCard(1, 1);
c0_config.extending(c0_Root);
