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
package org.robovm.apple.storekit;

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
import org.robovm.apple.uikit.*;
import org.robovm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("StoreKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKDownload/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class SKDownloadPtr extends Ptr<SKDownload, SKDownloadPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKDownload.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKDownload() {}
    protected SKDownload(Handle h, long handle) { super(h, handle); }
    protected SKDownload(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 12.0 and later.
     */
    @Property(selector = "state")
    public native SKDownloadState getState();
    /**
     * @deprecated Deprecated in iOS 12.0. Use -[SKDownload state]
     */
    @Deprecated
    @Property(selector = "downloadState")
    public native SKDownloadState getDownloadState();
    /**
     * @deprecated Deprecated in iOS 13.0. Use -[SKDownload expectedContentLength]
     */
    @Deprecated
    @Property(selector = "contentLength")
    public native long getContentLength();
    /**
     * @since Available in iOS 13.0 and later.
     */
    @Property(selector = "expectedContentLength")
    public native long getExpectedContentLength();
    @Property(selector = "contentIdentifier")
    public native String getContentIdentifier();
    @Property(selector = "contentURL")
    public native NSURL getContentURL();
    @Property(selector = "contentVersion")
    public native String getContentVersion();
    @Property(selector = "error")
    public native NSError getError();
    @Property(selector = "progress")
    public native float getProgress();
    @Property(selector = "timeRemaining")
    public native double getTimeRemaining();
    @Property(selector = "transaction")
    public native SKPaymentTransaction getTransaction();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @GlobalValue(symbol="SKDownloadTimeRemainingUnknown", optional=true)
    public static native double getRemainingTimeUnknown();
    
    
    /*</methods>*/
}
