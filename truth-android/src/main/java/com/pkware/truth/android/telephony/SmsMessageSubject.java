/*
 * Copyright 2013 Square, Inc.
 * Copyright 2016 PKWARE, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pkware.truth.android.telephony;

import android.telephony.SmsMessage;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Propositions for {@link SmsMessage} subjects.
 */
public class SmsMessageSubject extends Subject {

  @Nullable
  private final SmsMessage actual;

  public SmsMessageSubject(@Nonnull FailureMetadata failureMetadata, @Nullable SmsMessage actual) {
    super(failureMetadata, actual);
    this.actual = actual;
  }

  public void hasDisplayMessageBody(@Nullable String displayMessageBody) {
    check("getDisplayMessageBody()").that(actual.getDisplayMessageBody()).isEqualTo(displayMessageBody);
  }

  public void hasDisplayOriginatingAddress(@Nullable String displayOriginatingAddress) {
    check("getDisplayOriginatingAddress()").that(actual.getDisplayOriginatingAddress()).isEqualTo(displayOriginatingAddress);
  }

  public void hasEmailBody(@Nullable String emailBody) {
    check("getEmailBody()").that(actual.getEmailBody()).isEqualTo(emailBody);
  }

  public void hasEmailFrom(@Nullable String emailFrom) {
    check("getEmailFrom()").that(actual.getEmailFrom()).isEqualTo(emailFrom);
  }

  public void hasIndexOnIcc(int index) {
    check("getIndexOnIcc()").that(actual.getIndexOnIcc()).isEqualTo(index);
  }

  public void hasIndexOnSim(int index) {
    check("getIndexOnSim()").that(actual.getIndexOnSim()).isEqualTo(index);
  }

  public void hasMessageBody(@Nullable String messageBody) {
    check("getMessageBody()").that(actual.getMessageBody()).isEqualTo(messageBody);
  }

  public void hasMessageClass(@Nullable SmsMessage.MessageClass messageClass) {
    check("getMessageClass()").that(actual.getMessageClass()).isEqualTo(messageClass);
  }

  public void hasOriginatingAddress(@Nullable String originatingAddress) {
    check("getOriginatingAddress()").that(actual.getOriginatingAddress()).isEqualTo(originatingAddress);
  }

  public void hasPdu(@Nullable byte[] pdu) {
    check("getPdu()").that(actual.getPdu()).isEqualTo(pdu);
  }

  public void hasProtocolIdentifier(int protocolIdentifier) {
    check("getProtocolIdentifier()").that(actual.getProtocolIdentifier()).isEqualTo(protocolIdentifier);
  }

  public void hasPseudoSubject(@Nullable String pseudoSubject) {
    check("getPseudoSubject()").that(actual.getPseudoSubject()).isEqualTo(pseudoSubject);
  }

  public void hasServiceCenterAddress(@Nullable String address) {
    check("getServiceCenterAddress()").that(actual.getServiceCenterAddress()).isEqualTo(address);
  }

  public void hasStatus(int status) {
    check("getStatus()").that(actual.getStatus()).isEqualTo(status);
  }

  public void hasStatusOnIcc(int status) {
    check("getStatusOnIcc()").that(actual.getStatusOnIcc()).isEqualTo(status);
  }

  public void hasStatusOnSim(int status) {
    check("getStatusOnSim()").that(actual.getStatusOnSim()).isEqualTo(status);
  }

  public void hasTimestampMillis(long timestamp) {
    check("getTimestampMillis()").that(actual.getTimestampMillis()).isEqualTo(timestamp);
  }

  public void hasUserData(@Nullable byte[] data) {
    check("getUserData()").that(actual.getUserData()).isEqualTo(data);
  }

  public void isCphsMwiMessage() {
    check("isCphsMwiMessage()").that(actual.isCphsMwiMessage()).isTrue();
  }

  public void isEmail() {
    check("isEmail()").that(actual.isEmail()).isTrue();
  }

  public void isMWIClearMessage() {
    check("isMWIClearMessage()").that(actual.isMWIClearMessage()).isTrue();
  }

  public void isMWISetMessage() {
    check("isMWISetMessage()").that(actual.isMWISetMessage()).isTrue();
  }

  public void isMwiDontStore() {
    check("isMwiDontStore()").that(actual.isMwiDontStore()).isTrue();
  }

  public void isReplace() {
    check("isReplace()").that(actual.isReplace()).isTrue();
  }

  public void isReplyPathPresent() {
    check("isReplyPathPresent()").that(actual.isReplyPathPresent()).isTrue();
  }

  public void isStatusReportMessage() {
    check("isStatusReportMessage()").that(actual.isStatusReportMessage()).isTrue();
  }
}
