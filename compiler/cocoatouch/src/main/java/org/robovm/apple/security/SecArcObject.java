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
package org.robovm.apple.security;

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
import org.robovm.apple.corefoundation.*;
import org.robovm.apple.dispatch.*;

@Library("Security")
class /*<name>*/SecArcObject/*</name>*/ extends NSObject {

    public void secArcRetain() {
        secArcRetain(this.getHandle());
    }

    public void secArcRelease() {
        secArcRelease(this.getHandle());
    }

    /*<methods>*/
    @Bridge(symbol="sec_retain", optional=true)
    private static native void secArcRetain(@Pointer long obj);
    @Bridge(symbol="sec_release", optional=true)
    private static native void secArcRelease(@Pointer long obj);
    /*</methods>*/
}
