package com.ag.WineShop.service;

import com.ag.WineShop.dto.BoughtHistoryDTO;

import java.util.List;

public interface BoughtHistoryService {

    List<BoughtHistoryDTO> getHistoryByMedicationIdAndPatientId(BoughtHistoryRequestDTO boughtHistoryRequestDTO);
}
