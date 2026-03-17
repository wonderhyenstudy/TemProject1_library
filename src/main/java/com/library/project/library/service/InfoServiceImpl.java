package com.library.project.library.service;

import com.library.project.library.dto.LibraryInfoDTO;
import com.library.project.library.dto.LibraryStatsDTO;
import com.library.project.library.repository.InfoRepository;
import com.library.project.library.repository.LibraryStatsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class InfoServiceImpl implements InfoService { // 👈 인터페이스를 상속(구현)합니다.

    private final InfoRepository infoRepository;
    private final LibraryStatsRepository statsRepository;

    @Override
    public LibraryInfoDTO getStaticLibraryInfo() {
        return infoRepository.findById(1L)
                .map(entity -> LibraryInfoDTO.builder()
                        .libraryName(entity.getLibraryName())
                        .address(entity.getAddress())
                        .contact(entity.getContact())
                        .donationGuide(entity.getDonationGuide())
                        .build())
                .orElseGet(() -> {
                    log.warn("도서관 정보 데이터(ID: 1)가 없습니다.");
                    return new LibraryInfoDTO();
                });
    }

    @Override
    public List<LibraryStatsDTO> getLibraryStatistics() {
        return statsRepository.findAll().stream()
                .map(entity -> LibraryStatsDTO.builder()
                        .statId(entity.getStatId())
                        .categoryName(entity.getCategoryName())
                        .itemCount(entity.getItemCount())
                        .build())
                .collect(Collectors.toList());
    }
}
