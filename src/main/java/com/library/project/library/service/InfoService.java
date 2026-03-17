package com.library.project.library.service;

import com.library.project.library.dto.LibraryInfoDTO;
import com.library.project.library.dto.LibraryStatsDTO;
import java.util.List;

public interface InfoService {
    LibraryInfoDTO getStaticLibraryInfo();
    List<LibraryStatsDTO> getLibraryStatistics();
}