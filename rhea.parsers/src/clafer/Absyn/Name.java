package clafer.Absyn; // Java Package generated by the BNF Converter.

public abstract class Name implements java.io.Serializable {
  public abstract <R,A> R accept(Name.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(clafer.Absyn.Path p, A arg);

  }
}