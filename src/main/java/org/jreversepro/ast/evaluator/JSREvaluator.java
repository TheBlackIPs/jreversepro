/**
 *  @(#) JSREvaluator.java
 *
 * JReversePro - Java Decompiler / Disassembler.
 * Copyright (C) 2008 Karthik Kumar.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 *  
 *  	http://www.apache.org/licenses/LICENSE-2.0 
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 **/
package org.jreversepro.ast.evaluator;


import java.util.Arrays;

import org.jreversepro.ast.intermediate.JSRLine;
import org.jreversepro.ast.intermediate.RetLine;
import org.jreversepro.reflect.instruction.Instruction;


/**
 * @author akkumar
 * 
 */
public class JSREvaluator extends AbstractInstructionEvaluator {

  /**
   * @param context
   */
  public JSREvaluator(EvaluatorContext context) {
    super(context);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * net.sf.jrevpro.decompile.evaluator.AbstractInstructionEvaluator#evaluate
   * (net.sf.jrevpro.reflect.instruction.Instruction)
   */
  @Override
  void evaluate(Instruction ins) {
    switch (ins.opcode) {
    case OPCODE_JSR:
      statements.append(new JSRLine(ins));
      break;
    case OPCODE_RET:
      statements.append(new RetLine(ins));
      break;
    case OPCODE_JSRW:
      throw new UnsupportedOperationException("not yet implemented");
    }
    /**
     * opStack.push(String.valueOf(thisIns.index +3) , RET_ADDR);
     */
    // Represents finally
  }

  /*
   * (non-Javadoc)
   * 
   * @seenet.sf.jrevpro.decompile.evaluator.AbstractInstructionEvaluator#
   * getProcessingOpcodes()
   */
  @Override
  Iterable<Integer> getProcessingOpcodes() {
    return Arrays.asList(OPCODE_JSR, OPCODE_JSRW, OPCODE_RET);
  }

}
