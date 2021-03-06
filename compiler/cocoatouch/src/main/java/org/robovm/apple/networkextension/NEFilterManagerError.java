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
package org.robovm.apple.networkextension;

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
import org.robovm.apple.security.*;
import org.robovm.apple.network.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedSIntMarshaler.class) @Library("NetworkExtension")/*</annotations>*/
public enum /*<name>*/NEFilterManagerError/*</name>*/ implements ValuedEnum {
    /*<values>*/
    ConfigurationInvalid(1L),
    ConfigurationDisabled(2L),
    ConfigurationStale(3L),
    ConfigurationCannotBeRemoved(4L),
    /**
     * @since Available in iOS 13.0 and later.
     */
    ConfigurationPermissionDenied(5L),
    /**
     * @since Available in iOS 13.0 and later.
     */
    ConfigurationInternalError(6L);
    /*</values>*/

    /*<bind>*/static { Bro.bind(NEFilterManagerError.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*/
    @GlobalValue(symbol="NEFilterErrorDomain", optional=true)
    public static native String getClassDomain();
    /*</methods>*/

    private final long n;

    private /*<name>*/NEFilterManagerError/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/NEFilterManagerError/*</name>*/ valueOf(long n) {
        for (/*<name>*/NEFilterManagerError/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/NEFilterManagerError/*</name>*/.class.getName());
    }
}
