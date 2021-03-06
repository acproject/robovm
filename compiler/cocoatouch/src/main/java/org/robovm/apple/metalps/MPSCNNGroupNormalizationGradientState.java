/*
 * Copyright (C) 2013-2015 RoboVM AB
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.robovm.apple.metalps;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import org.robovm.objc.*;
import org.robovm.objc.annotation.*;
import org.robovm.objc.block.*;
import org.robovm.rt.*;
import org.robovm.rt.annotation.*;
import org.robovm.rt.bro.*;
import org.robovm.rt.bro.annotation.*;
import org.robovm.rt.bro.ptr.*;
import org.robovm.apple.foundation.*;
import org.robovm.apple.coregraphics.*;
import org.robovm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 13.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MetalPerformanceShaders") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPSCNNGroupNormalizationGradientState/*</name>*/ 
    extends /*<extends>*/MPSNNGradientState/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MPSCNNGroupNormalizationGradientStatePtr extends Ptr<MPSCNNGroupNormalizationGradientState, MPSCNNGroupNormalizationGradientStatePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPSCNNGroupNormalizationGradientState.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected MPSCNNGroupNormalizationGradientState() {}
    protected MPSCNNGroupNormalizationGradientState(Handle h, long handle) { super(h, handle); }
    protected MPSCNNGroupNormalizationGradientState(SkipInit skipInit) { super(skipInit); }
    /**
     * @since Available in iOS 11.3 and later.
     */
    @Method(selector = "initWithDevice:resourceList:")
    public MPSCNNGroupNormalizationGradientState(MTLDevice device, MPSStateResourceList resourceList) { super(device, resourceList); }
    @Method(selector = "initWithResources:")
    public MPSCNNGroupNormalizationGradientState(NSArray<?> resources) { super(resources); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "groupNormalization")
    public native MPSCNNGroupNormalization getGroupNormalization();
    @Property(selector = "gamma")
    public native MTLBuffer getGamma();
    @Property(selector = "beta")
    public native MTLBuffer getBeta();
    @Property(selector = "gradientForGamma")
    public native MTLBuffer getGradientForGamma();
    @Property(selector = "gradientForBeta")
    public native MTLBuffer getGradientForBeta();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    
    /*</methods>*/
}
