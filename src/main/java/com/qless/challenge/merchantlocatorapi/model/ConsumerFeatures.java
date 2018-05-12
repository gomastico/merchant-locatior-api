package com.qless.challenge.merchantlocatorapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumerFeatures {

    private boolean hasAppointments;
    private boolean hasCustomScreens;
    private boolean hasSMSSummoning;
    private boolean hasVoiceQueuing;
    private boolean hasTransactionTypes;
    private boolean hasMobileAccess;
    private int maxSimultaneousQueues;
    private boolean supportsPartySize;
    private boolean shouldDisplayTransactionTypesBeforeQueues;
    private List<String> supportedLocales;
}
