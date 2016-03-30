/*
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

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.SubjectFactory;

import static com.google.common.truth.Truth.assertThat;

/**
 * Propositions for {@link SmsMessage} subjects.
 */
public class SmsMessageSubject extends Subject<SmsMessageSubject, SmsMessage> {
  protected SmsMessageSubject(FailureStrategy failureStrategy, SmsMessage subject) {
    super(failureStrategy, subject);
  }

  public static SubjectFactory<SmsMessageSubject, SmsMessage> type() {
    return new SubjectFactory<SmsMessageSubject, SmsMessage>() {
      @Override
      public SmsMessageSubject getSubject(FailureStrategy fs, SmsMessage that) {
        return new SmsMessageSubject(fs, that);
      }
    };
  }

  public SmsMessageSubject hasDisplayMessageBody(String displayMessageBody) {
    assertThat(getSubject().getDisplayMessageBody())
        .named("display message body")
        .isEqualTo(displayMessageBody);
    return this;
  }

  public SmsMessageSubject hasDisplayOriginatingAddress(String displayOriginatingAddress) {
    assertThat(getSubject().getDisplayOriginatingAddress())
        .named("display originating address")
        .isEqualTo(displayOriginatingAddress);
    return this;
  }

  public SmsMessageSubject hasEmailBody(String emailBody) {
    assertThat(getSubject().getEmailBody())
        .named("email body")
        .isEqualTo(emailBody);
    return this;
  }

  public SmsMessageSubject hasEmailFrom(String emailFrom) {
    assertThat(getSubject().getEmailFrom())
        .named("email from")
        .isEqualTo(emailFrom);
    return this;
  }

  public SmsMessageSubject hasIndexOnIcc(int index) {
    assertThat(getSubject().getIndexOnIcc())
        .named("index on ICC card")
        .isEqualTo(index);
    return this;
  }

  public SmsMessageSubject hasIndexOnSim(int index) {
    assertThat(getSubject().getIndexOnSim())
        .named("index on SIM card")
        .isEqualTo(index);
    return this;
  }

  public SmsMessageSubject hasMessageBody(String messageBody) {
    assertThat(getSubject().getMessageBody())
        .named("message body")
        .isEqualTo(messageBody);
    return this;
  }

  public SmsMessageSubject hasMessageClass(SmsMessage.MessageClass messageClass) {
    assertThat(getSubject().getMessageClass())
        .named("message class")
        .isEqualTo(messageClass);
    return this;
  }

  public SmsMessageSubject hasOriginatingAddress(String originatingAddress) {
    assertThat(getSubject().getOriginatingAddress())
        .named("originating address")
        .isEqualTo(originatingAddress);
    return this;
  }

  public SmsMessageSubject hasPdu(byte[] pdu) {
    assertThat(getSubject().getPdu())
        .named("PDU")
        .isEqualTo(pdu);
    return this;
  }

  public SmsMessageSubject hasProtocolIdentifier(int protocolIdentifier) {
    assertThat(getSubject().getProtocolIdentifier())
        .named("protocol identifier")
        .isEqualTo(protocolIdentifier);
    return this;
  }

  public SmsMessageSubject hasPseudoSubject(String pseudoSubject) {
    assertThat(getSubject().getPseudoSubject())
        .named("psuedo subject")
        .isEqualTo(pseudoSubject);
    return this;
  }

  public SmsMessageSubject hasServiceCenterAddress(String address) {
    assertThat(getSubject().getServiceCenterAddress())
        .named("service center address")
        .isEqualTo(address);
    return this;
  }

  public SmsMessageSubject hasStatus(int status) {
    assertThat(getSubject().getStatus())
        .named("status")
        .isEqualTo(status);
    return this;
  }

  public SmsMessageSubject hasStatusOnIcc(int status) {
    assertThat(getSubject().getStatusOnIcc())
        .named("status on the ICC card")
        .isEqualTo(status);
    return this;
  }

  public SmsMessageSubject hasStatusOnSim(int status) {
    assertThat(getSubject().getStatusOnSim())
        .named("status on the SIM card")
        .isEqualTo(status);
    return this;
  }

  public SmsMessageSubject hasTimestampMillis(long timestamp) {
    assertThat(getSubject().getTimestampMillis())
        .named("timestamp in millis")
        .isEqualTo(timestamp);
    return this;
  }

  public SmsMessageSubject hasUserData(byte[] data) {
    assertThat(getSubject().getUserData())
        .named("user data")
        .isEqualTo(data);
    return this;
  }

  public SmsMessageSubject isCphsMwiMessage() {
    assertThat(getSubject().isCphsMwiMessage())
        .named("is CPHS MWI message")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isEmail() {
    assertThat(getSubject().isEmail())
        .named("is email")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isMWIClearMessage() {
    assertThat(getSubject().isMWIClearMessage())
        .named("is MWI clear message")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isMWISetMessage() {
    assertThat(getSubject().isMWISetMessage())
        .named("is MWI set message")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isMwiDontStore() {
    assertThat(getSubject().isMwiDontStore())
        .named("is MWI message that shouldn't be stored")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isReplace() {
    assertThat(getSubject().isReplace())
        .named("is replace short message")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isReplyPathPresent() {
    assertThat(getSubject().isReplyPathPresent())
        .named("is 'TP-Reply-Path' bit set")
        .isTrue();
    return this;
  }

  public SmsMessageSubject isStatusReportMessage() {
    assertThat(getSubject().isStatusReportMessage())
        .named("is a status report message")
        .isTrue();
    return this;
  }
}
