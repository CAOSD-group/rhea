defaultScope(1);
intRange(-8, 7);
stringLength(16);

c0_Root = Abstract("c0_Root");
c0_A = c0_Root.addChild("c0_A").withCard(1, 1);
c0_AP = c0_A.addChild("c0_AP").withCard(0, 1).withGroupCard(1, 1);
c0_A2 = c0_AP.addChild("c0_A2").withCard(0, 1);
c0_A3 = c0_AP.addChild("c0_A3").withCard(0, 1);
c0_A1 = c0_AP.addChild("c0_A1").withCard(0, 1);
c0_config = Clafer("c0_config").withCard(1, 1);
c0_config.extending(c0_Root);
