package patterns;

import DiffModel.Delete;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import patterns.util.DeleteQuerySpecification;

/**
 * Pattern-specific match representation of the patterns.delete pattern,
 * to be used in conjunction with {@link DeleteMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see DeleteMatcher
 * @see DeleteProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class DeleteMatch extends BasePatternMatch {
  private Delete fDeleteOp;
  
  private static List<String> parameterNames = makeImmutableList("deleteOp");
  
  private DeleteMatch(final Delete pDeleteOp) {
    this.fDeleteOp = pDeleteOp;
    
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("deleteOp".equals(parameterName)) return this.fDeleteOp;
    return null;
    
  }
  
  public Delete getDeleteOp() {
    return this.fDeleteOp;
    
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("deleteOp".equals(parameterName) ) {
    	this.fDeleteOp = (DiffModel.Delete) newValue;
    	return true;
    }
    return false;
    
  }
  
  public void setDeleteOp(final Delete pDeleteOp) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fDeleteOp = pDeleteOp;
    
  }
  
  @Override
  public String patternName() {
    return "patterns.delete";
    
  }
  
  @Override
  public List<String> parameterNames() {
    return DeleteMatch.parameterNames;
    
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fDeleteOp};
    
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"deleteOp\"=" + prettyPrintValue(fDeleteOp));
    return result.toString();
    
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fDeleteOp == null) ? 0 : fDeleteOp.hashCode());
    return result;
    
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof DeleteMatch)) { // this should be infrequent
    	if (obj == null)
    		return false;
    	if (!(obj instanceof IPatternMatch))
    		return false;
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    DeleteMatch other = (DeleteMatch) obj;
    if (fDeleteOp == null) {if (other.fDeleteOp != null) return false;}
    else if (!fDeleteOp.equals(other.fDeleteOp)) return false;
    return true;
  }
  
  @Override
  public DeleteQuerySpecification specification() {
    try {
    	return DeleteQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException	(ex);
    }
    
  }
  
  @SuppressWarnings("all")
  static final class Mutable extends DeleteMatch {
    Mutable(final Delete pDeleteOp) {
      super(pDeleteOp);
      
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  
  @SuppressWarnings("all")
  static final class Immutable extends DeleteMatch {
    Immutable(final Delete pDeleteOp) {
      super(pDeleteOp);
      
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
  
}