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
package org.robovm.apple.addressbook;

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
import org.robovm.apple.corefoundation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("AddressBook")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/ABAddressBook/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    public interface RequestAccessCompletionHandler {
        void requestAccess(boolean granted, NSError error);
    }
    public interface ExternalChangeCallback {
        void externalChange(ABAddressBook addressBook, NSDictionary<?, ?> info);
    }
    
    private static final java.util.concurrent.atomic.AtomicLong changeCallbackId = new java.util.concurrent.atomic.AtomicLong();
    private static final LongMap<ExternalChangeCallback> externalChangeCallbacks = new LongMap<>();
    private static final java.lang.reflect.Method cbExternalChange;
    
    static {
        try {
            cbExternalChange = ABAddressBook.class.getDeclaredMethod("cbExternalChange", ABAddressBook.class, NSDictionary.class, long.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<bind>*/static { Bro.bind(ABAddressBook.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    @Callback
    private static void cbExternalChange(ABAddressBook addressBook, NSDictionary<?, ?> info, @Pointer long refcon) {
        ExternalChangeCallback callback = null;
        synchronized (externalChangeCallbacks) {
            callback = externalChangeCallbacks.get(refcon);
        }
        callback.externalChange(addressBook, info);
    }
    
    public void registerExternalChangeCallback(ExternalChangeCallback callback) {
        long refconId = ABAddressBook.changeCallbackId.getAndIncrement();
        registerExternalChangeCallback(new FunctionPtr(cbExternalChange), refconId);
        synchronized (externalChangeCallbacks) {
            externalChangeCallbacks.put(refconId, callback);
        }
    }
    public void unregisterExternalChangeCallback(ExternalChangeCallback callback) {
        long refconId = 0;
        synchronized (externalChangeCallbacks) {
            for (LongMap.Entry<ExternalChangeCallback> entry : externalChangeCallbacks.entries()) {
                if (entry.value == callback) {
                    refconId = entry.key;
                    externalChangeCallbacks.remove(refconId);
                    break;
                }
            }
        }
        unregisterExternalChangeCallback(new FunctionPtr(cbExternalChange), refconId);
    }
    
    public static String getLocalizedLabel(ABPropertyLabel label) {
        return getLocalizedLabel(label.value().toString());
    }
    /*<methods>*/
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore authorizationStatusForEntityType:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookGetAuthorizationStatus", optional=true)
    public static native ABAuthorizationStatus getAuthorizationStatus();
    /**
     * @deprecated Deprecated in iOS 9.0. use [[CNContactStore alloc] init]
     */
    @Deprecated
    public static ABAddressBook create(NSDictionary options) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       ABAddressBook result = create(options, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @deprecated Deprecated in iOS 9.0. use [[CNContactStore alloc] init]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCreateWithOptions", optional=true)
    private static native @org.robovm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) ABAddressBook create(NSDictionary options, NSError.NSErrorPtr error);
    /**
     * @deprecated Deprecated in iOS 9.0. use [[CNContactStore alloc] init]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCreate", optional=true)
    public static native ABAddressBook create();
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore requestAccessForEntityType:completionHandler:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookRequestAccessWithCompletion", optional=true)
    public native void requestAccess(@Block RequestAccessCompletionHandler completion);
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore executeSaveRequest:error:]
     */
    @Deprecated
    public boolean save() throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = save(ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore executeSaveRequest:error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookSave", optional=true)
    private native boolean save(NSError.NSErrorPtr error);
    /**
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookHasUnsavedChanges", optional=true)
    public native boolean hasUnsavedChanges();
    /**
     * @deprecated Deprecated in iOS 9.0. use CNSaveRequest
     */
    @Deprecated
    public boolean addRecord(ABRecord record) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = addRecord(record, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @deprecated Deprecated in iOS 9.0. use CNSaveRequest
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookAddRecord", optional=true)
    private native boolean addRecord(ABRecord record, NSError.NSErrorPtr error);
    /**
     * @deprecated Deprecated in iOS 9.0. use CNSaveRequest
     */
    @Deprecated
    public boolean removeRecord(ABRecord record) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = removeRecord(record, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @deprecated Deprecated in iOS 9.0. use CNSaveRequest
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookRemoveRecord", optional=true)
    private native boolean removeRecord(ABRecord record, NSError.NSErrorPtr error);
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNLabeledValue localizedStringForLabel:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCopyLocalizedLabel", optional=true)
    public static native @org.robovm.rt.bro.annotation.Marshaler(CFString.AsStringNoRetainMarshaler.class) String getLocalizedLabel(String label);
    /**
     * @deprecated Deprecated in iOS 9.0. use CNContactStoreDidChangeNotification
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookRegisterExternalChangeCallback", optional=true)
    protected native void registerExternalChangeCallback(FunctionPtr callback, @Pointer long context);
    /**
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookUnregisterExternalChangeCallback", optional=true)
    protected native void unregisterExternalChangeCallback(FunctionPtr callback, @Pointer long context);
    /**
     * @deprecated Deprecated in iOS 9.0. refetch CN objects
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookRevert", optional=true)
    public native void revert();
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore containersMatchingPredicate:[CNContainer predicateForContainersWithIdentifiers: @[CNContactStore.defaultContainerIdentifier]] error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCopyDefaultSource", optional=true)
    public native @org.robovm.rt.bro.annotation.Marshaler(ABRecord.NoRetainMarshaler.class) ABSource getDefaultSource();
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore containersMatchingPredicate:[CNContainer predicateForContainersWithIdentifiers:] error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookGetSourceWithRecordID", optional=true)
    public native ABSource getSource(int sourceID);
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore containersMatchingPredicate:nil error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCopyArrayOfAllSources", optional=true)
    public native @org.robovm.rt.bro.annotation.Marshaler(ABSource.AsListMarshaler.class) List<ABSource> getAllSources();
    /**
     * @deprecated Deprecated in iOS 9.0. use count of fetch results for CNContactFetchRequest with predicate = nil
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookGetPersonCount", optional=true)
    public native @MachineSizedSInt long getPersonCount();
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore unifiedContactWithIdentifier:keysToFetch:error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookGetPersonWithRecordID", optional=true)
    public native ABPerson getPerson(int recordID);
    /**
     * @deprecated Deprecated in iOS 9.0. use CNContactFetchRequest with predicate = nil
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCopyArrayOfAllPeople", optional=true)
    public native @org.robovm.rt.bro.annotation.Marshaler(ABPerson.AsListMarshaler.class) List<ABPerson> getAllPeople();
    /**
     * @deprecated Deprecated in iOS 9.0. use CNContactFetchRequest with predicate = [CNContact predicateForContactsInContainerWithIdentifier:] and unifyResults = NO
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCopyArrayOfAllPeopleInSource", optional=true)
    public native @org.robovm.rt.bro.annotation.Marshaler(ABPerson.AsListMarshaler.class) List<ABPerson> getAllPeopleInSource(ABSource source);
    /**
     * @deprecated Deprecated in iOS 9.0. use CNContactFetchRequest with predicate = [CNContact predicateForContactsInContainerWithIdentifier:] and unifyResults = NO and sortOrder
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCopyArrayOfAllPeopleInSourceWithSortOrdering", optional=true)
    public native @org.robovm.rt.bro.annotation.Marshaler(ABPerson.AsListMarshaler.class) List<ABPerson> getAllPeopleInSource(ABSource source, ABPersonSortOrdering sortOrdering);
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore unifiedContactsMatchingPredicate:[CNContact predicateForContactsMatchingName:] keysToFetch: error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCopyPeopleWithName", optional=true)
    public native @org.robovm.rt.bro.annotation.Marshaler(ABPerson.AsListMarshaler.class) List<ABPerson> getPeople(String name);
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore groupsMatchingPredicate:[CNGroup predicateForGroupsWithIdentifiers:] error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookGetGroupWithRecordID", optional=true)
    public native ABGroup getGroup(int recordID);
    /**
     * @deprecated Deprecated in iOS 9.0. use count of fetch results for [CNContactStore groupsMatchingPredicate:nil error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookGetGroupCount", optional=true)
    public native @MachineSizedSInt long getGroupCount();
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore groupsMatchingPredicate:nil error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCopyArrayOfAllGroups", optional=true)
    public native @org.robovm.rt.bro.annotation.Marshaler(ABGroup.AsListMarshaler.class) List<ABGroup> getAllGroups();
    /**
     * @deprecated Deprecated in iOS 9.0. use [CNContactStore groupsMatchingPredicate:[CNGroup predicateForGroupsInContainerWithIdentifier:] error:]
     */
    @Deprecated
    @Bridge(symbol="ABAddressBookCopyArrayOfAllGroupsInSource", optional=true)
    public native @org.robovm.rt.bro.annotation.Marshaler(ABGroup.AsListMarshaler.class) List<ABGroup> getAllGroupsInSource(ABSource source);
    /*</methods>*/
}
