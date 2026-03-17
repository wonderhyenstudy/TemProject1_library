package com.library.project.library.controller;


import com.library.project.library.dto.LibraryInfoDTO;
import com.library.project.library.dto.LibraryStatsDTO;
import com.library.project.library.service.InfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/info") // 브라우저에서 http://localhost:8080/info 로 접속
@Log4j2
@RequiredArgsConstructor
public class InfoController {

    private final InfoService infoService;

    @GetMapping("/basic")
    public void getLibraryInfo(Model model) {
        log.info("도서관 안내 및 자료현황 페이지 접속...");

        // 1. DB에서 도서관 기본 정보(이름, 주소 등) 가져오기
        LibraryInfoDTO infoDTO = infoService.getStaticLibraryInfo();

        // 2. DB에서 자료현황(통계) 리스트 가져오기
        List<LibraryStatsDTO> statsList = infoService.getLibraryStatistics();

        // 3. 뷰(HTML)로 데이터 전달
        model.addAttribute("info", infoDTO);
        model.addAttribute("stats", statsList);

        // 💡 인사말은 DB에 없으므로 여기서 넘기지 않고, HTML에 직접 작성합니다.
    }
}
