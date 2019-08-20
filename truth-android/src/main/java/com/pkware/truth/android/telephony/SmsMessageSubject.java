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

  public SmsMessageSubject hasDisplayMessageBody(@Nullable String displayMessageBody) {
    check("getDisplayMessageBody()").that(actual.getDisplayMessageBody()).isEqualTo(displayMessageBody);
    return this;
  }

  public SmsMessageSubject hasDisplayOriginatingAddress(@Nullable String displayOriginatingAddress) {
    check("getDisplayOriginatingAddress()").that(actual.getDisplayOriginatingAddress()).isEqualTo(displayOriginatingAddress);
    return this;
  }

  public SmsMessageSubject hasEmailBody(@Nullable String emailBody) {
    check("getEmailBody()").that(actual.getEmailBody()).isEqualTo(emailBody);
    return this;
  }

  public SmsMessageSubject hasEmailFrom(@Nullable String emailFrom) {
    check("getEmailFrom()").that(actual.getEmailFrom()).isEqualTo(emailFrom);
    return this;
  }

  public SmsMessageSubject hasIndexOnIcc(int index) {
    check("getIndexOnIcc()").that(actual.getIndexOnIcc()).isEqualTo(index);
    return this;
  }

  public SmsMessageSubject hasIndexOnSim(int index) {
    check("getIndexOnSim()").that(actual.getIndexOnSim()).isEqualTo(index);
    return this;
  }

  public SmsMessageSubject hasMessageBody(@Nullable String messageBody) {
    check("getMessageBody()").that(actual.getMessageBody()).isEqualTo(messageBody);
    return this;
  }

  public SmsMessageSubject hasMessageClass(@Nullable SmsMessage.MessageClass messageClass) {
    check("getMessageClass()").that(actual.getMessageClass()).isEqualTo(messageClass);
    return this;
  }

  public SmsMessageSubject hasOriginatingAddress(@Nullable String originatingAddress) {
    check("getOriginatingAddress()").that(actual.getOriginatingAddress()).isEqualTo(originatingAddress);
    return this;
  }

  public SmsMessageSubject hasPdu(@Nullable byte[] pdu) {
    check("getPdu()").that(actual.getPdu()).isEqualTo(pdu);
    return this;
  }

  public SmsMessageSubject hasProtocolIdentifier(int protocolIdentifier) {
    check("getProtocolIdentifier()").that(actual.getProtocolIdentifier()).isEqualTo(protocolIdentifier);
    return this;
  }

  public SmsMessageSubject hasPseudoSubject(@Nullable String pseudoSubject) {
    check("getPseudoSubject()").that(actual.getPseudoSubject()).isEqualTo(pseudoSubject);
    return this;
  }

  public SmsMessageSubject hasServiceCenterAddress(@Nullable String address) {
    check("getServiceCenterAddress()").that(actual.getServiceCenterAddress()).isEqualTo(address);
    return this;
  }

  public SmsMessageSubject hasStatus(int status) {
    check("getStatus()").that(actual.getStatus()).isEqualTo(status);
    return this;
  }

  public SmsMessageSubject hasStatusOnIcc(int status) {
    check("getStatusOnIcc()").that(actual.getStatusOnIcc()).isEqualTo(status);
    return this;
  }

  public SmsMessageSubject hasStatusOnSim(int status) {
    check("getStatusOnSim()").that(actual.getStatusOnSim()).isEqualTo(status);
    return this;
  }

  public SmsMessageSubject hasTimestampMillis(long timestamp) {
    check("getTimestampMillis()").that(actual.getTimestampMillis()).isEqualTo(timestamp);
    return this;
  }

  public SmsMessageSubject hasUserData(@Nullable byte[] data) {
    check("getUserData()").that(actual.getUserData()).isEqualTo(data);
    return this;
  }

  public SmsMessageSubject isCphsMwiMessage() {
    check("isCphsMwiMessage()").that(actual.isCphsMwiMessage()).isTrue();
    return this;
  }

  public SmsMessageSubject isEmail() {
    check("isEmail()").that(actual.isEmail()).isTrue();
    return this;
  }

  public SmsMessageSubject isMWIClearMessage() {
    check("isMWIClearMessage()").that(actual.isMWIClearMessage()).isTrue();
    return this;
  }

  public SmsMessageSubject isMWISetMessage() {
    check("isMWISetMessage()").that(actual.isMWISetMessage()).isTrue();
    return this;
  }

  public SmsMessageSubject isMwiDontStore() {
    check("isMwiDontStore()").that(actual.isMwiDontStore()).isTrue();
    return this;
  }

  public SmsMessageSubject isReplace() {
    check("isReplace()").that(actual.isReplace()).isTrue();
    return this;
  }

  public SmsMessageSubject isReplyPathPresent() {
    check("isReplyPathPresent()").that(actual.isReplyPathPresent()).isTrue();
    return this;
  }

  public SmsMessageSubject isStatusReportMessage() {
    check("isStatusReportMessage()").that(actual.isStatusReportMessage()).isTrue();
    return this;
  }
}
