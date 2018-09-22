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

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SmsMessage} subjects.
 */
public class SmsMessageSubject extends Subject<SmsMessageSubject, SmsMessage> {
  protected SmsMessageSubject(FailureMetadata failureMetadata, SmsMessage subject) {
    super(failureMetadata, subject);
  }

  public static Subject.Factory<SmsMessageSubject, SmsMessage> type() {
    return new Subject.Factory<SmsMessageSubject, SmsMessage>() {
      @Override
      public SmsMessageSubject createSubject(FailureMetadata fm, SmsMessage that) {
        return new SmsMessageSubject(fm, that);
      }
    };
  }

  public SmsMessageSubject hasDisplayMessageBody(String displayMessageBody) {
    assertThat(actual().getDisplayMessageBody())
        .named("display message body")
        .isEqualTo(displayMessageBody);
    return this;
  }

  public SmsMessageSubject hasDisplayOriginatingAddress(String displayOriginatingAddress) {
    assertThat(actual().getDisplayOriginatingAddress())
        .named("display originating address")
        .isEqualTo(displayOriginatingAddress);
    return this;
  }

  public SmsMessageSubject hasEmailBody(String emailBody) {
    assertThat(actual().getEmailBody())
        .named("email body")
        .isEqualTo(emailBody);
    return this;
  }

  public SmsMessageSubject hasEmailFrom(String emailFrom) {
    assertThat(actual().getEmailFrom())
        .named("email from")
        .isEqualTo(emailFrom);
    return this;
  }

  public SmsMessageSubject hasIndexOnIcc(int index) {
    assertThat(actual().getIndexOnIcc())
        .named("index on ICC card")
        .isEqualTo(index);
    return this;
  }

  public SmsMessageSubject hasIndexOnSim(int index) {
    assertThat(actual().getIndexOnSim())
        .named("index on SIM card")
        .isEqualTo(index);
    return this;
  }

  public SmsMessageSubject hasMessageBody(String messageBody) {
    assertThat(actual().getMessageBody())
        .named("message body")
        .isEqualTo(messageBody);
    return this;
  }

  public SmsMessageSubject hasMessageClass(SmsMessage.MessageClass messageClass) {
    assertThat(actual().getMessageClass())
        .named("message class")
        .isEqualTo(messageClass);
    return this;
  }

  public SmsMessageSubject hasOriginatingAddress(String originatingAddress) {
    assertThat(actual().getOriginatingAddress())
        .named("originating address")
        .isEqualTo(originatingAddress);
    return this;
  }

  public SmsMessageSubject hasPdu(byte[] pdu) {
    assertThat(actual().getPdu())
        .named("PDU")
        .isEqualTo(pdu);
    return this;
  }

  public SmsMessageSubject hasProtocolIdentifier(int protocolIdentifier) {
    assertThat(actual().getProtocolIdentifier())
        .named("protocol identifier")
        .isEqualTo(protocolIdentifier);
    return this;
  }

  public SmsMessageSubject hasPseudoSubject(String pseudoSubject) {
    assertThat(actual().getPseudoSubject())
        .named("psuedo subject")
        .isEqualTo(pseudoSubject);
    return this;
  }

  public SmsMessageSubject hasServiceCenterAddress(String address) {
    assertThat(actual().getServiceCenterAddress())
        .named("service center address")
        .isEqualTo(address);
    return this;
  }

  public SmsMessageSubject hasStatus(int status) {
    assertThat(actual().getStatus())
        .named("status")
        .isEqualTo(status);
    return this;
  }

  public SmsMessageSubject hasStatusOnIcc(int status) {
    assertThat(actual().getStatusOnIcc())
        .named("status on the ICC card")
        .isEqualTo(status);
    return this;
  }

  public SmsMessageSubject hasStatusOnSim(int status) {
    assertThat(actual().getStatusOnSim())
        .named("status on the SIM card")
        .isEqualTo(status);
    return this;
  }

  public SmsMessageSubject hasTimestampMillis(long timestamp) {
    assertThat(actual().getTimestampMillis())
        .named("timestamp in millis")
        .isEqualTo(timestamp);
    return this;
  }

  public SmsMessageSubject hasUserData(byte[] data) {
    assertThat(actual().getUserData())
        .named("user data")
        .isEqualTo(data);
    return this;
  }

  public SmsMessageSubject isCphsMwiMessage() {
    assertThat(actual().isCphsMwiMessage())
        .named("is CPHS MWI message")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isEmail() {
    assertThat(actual().isEmail())
        .named("is email")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isMWIClearMessage() {
    assertThat(actual().isMWIClearMessage())
        .named("is MWI clear message")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isMWISetMessage() {
    assertThat(actual().isMWISetMessage())
        .named("is MWI set message")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isMwiDontStore() {
    assertThat(actual().isMwiDontStore())
        .named("is MWI message that shouldn't be stored")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isReplace() {
    assertThat(actual().isReplace())
        .named("is replace short message")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isReplyPathPresent() {
    assertThat(actual().isReplyPathPresent())
        .named("is 'TP-Reply-Path' bit set")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isStatusReportMessage() {
    assertThat(actual().isStatusReportMessage())
        .named("is a status report message")
        .isTrue();
    return this;
  }
}
