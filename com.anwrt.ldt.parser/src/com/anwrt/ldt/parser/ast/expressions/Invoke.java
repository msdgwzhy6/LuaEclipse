/**
 * @author	Kevin KIN-FOO <kkinfoo@anyware-tech.com>
 * @date $Date: 2009-06-15 17:55:03 +0200 (lun., 15 juin 2009) $
 * $Author: kkinfoo $
 * $Id: Invoke.java 1841 2009-06-15 15:55:03Z kkinfoo $
 */
package com.anwrt.ldt.parser.ast.expressions;

import java.util.List;

import org.eclipse.dltk.ast.ASTVisitor;
import org.eclipse.dltk.ast.expressions.CallArgumentsList;
import org.eclipse.dltk.ast.expressions.Expression;

import com.anwrt.ldt.parser.LuaExpressionConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class Invoke.
 */
public class Invoke extends Call implements LuaExpressionConstants {

	/** The args. */
	private List<Expression> args;
	private Expression string;

	/**
	 * Instantiates a new invoke.
	 * 
	 * @param start the start
	 * @param end the end
	 * @param module the module
	 */
	public Invoke(int start, int end, Expression module, Expression string) {
		super(start, end, module, new CallArgumentsList());
		this.string = string;
	}

	/**
	 * Instantiates a new invoke.
	 * 
	 * @param start the start
	 * @param end the end
	 * @param module the module
	 * @param parameters the parameters
	 */
	public Invoke(int start, int end, Expression module,Expression string,
			CallArgumentsList parameters) {
		super(start, end, module);
		this.string = string;
	}
	@Override
	public int getKind() {
		return E_INVOKE;
	}
	/* (non-Javadoc)
	 * @see com.anwrt.ldt.parser.ast.expressions.Call#traverse(org.eclipse.dltk.ast.ASTVisitor)
	 */
	public void traverse(ASTVisitor visitor) throws Exception {
		if (visitor.visit(this)) {
			super.traverse(visitor);
			string.traverse(visitor);
			for (Expression parameter : args) {
				parameter.traverse(visitor);
			}
			visitor.endvisit(this);
		}
	}
}