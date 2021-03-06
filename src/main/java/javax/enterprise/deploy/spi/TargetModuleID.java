/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.enterprise.deploy.spi;

/**
 * A TargetModuleID interface represents a unique
 * identifier for a deployed application module. 
 * A deployable application module can be an EAR, 
 * JAR, WAR or RAR file.  
 *
 * A TargetModuleID can represent a root module or 
 * a child module.  A root module TargetModuleID 
 * has no parent.  It represents a deployed EAR 
 * file or stand alone module.  A child module
 * TargetModuleID represents a deployed sub module
 * of a Java EE application. 
 *
 * A child TargetModuleID has only one parent,
 * the super module it was bundled and deployed
 * with.
 *
 * The identifier consists of the target name
 * and the unique identifier for the deployed
 * application module. 
 */
public interface TargetModuleID
{
   /**
    * Retrieve the name of the target server.
    * this module was deployed to.
    *
    * @return Target an object representing
    *         a server target.
    */
   public Target getTarget();

   /**
    * Retrieve the id assigned to represent
    * the deployed module.
    */
   public String getModuleID();


   /**
    * If this TargetModulID represents a web
    * module retrieve the URL for it.
    * 
    * @return the URL of a web module or null
    *         if the module is not a web module.
    */
   public String getWebURL();

   /**
    * Retrieve the identifier representing
    * the deployed module.
    */
   public String toString();

   /**
    * Retrieve the identifier of the parent
    * object of this deployed module. If there
    * is no parent then this is the root object
    * deployed.  The root could represent an EAR 
    * file or it could be a stand alone module 
    * that was deployed.
    *
    * @return the TargetModuleID of the parent
    *         of this object. A <code>null</code>
    *         value means this module is the root
    *         object deployed.
    */
   public TargetModuleID getParentTargetModuleID();

   /**
    * Retrieve a list of identifiers of the children
    * of this deployed module.
    *
    * @return a list of TargetModuleIDs identifying the 
    *         childern of this object. A <code>null</code>
    *         value means this module has no childern
    */
   public TargetModuleID[] getChildTargetModuleID();
}
