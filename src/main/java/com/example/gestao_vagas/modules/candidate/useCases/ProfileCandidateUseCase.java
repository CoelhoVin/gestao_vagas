package com.example.gestao_vagas.modules.candidate.useCases;

import com.example.gestao_vagas.exceptions.UserNotFoundException;
import com.example.gestao_vagas.modules.candidate.CandidateRepository;
import com.example.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;


    public ProfileCandidateResponseDTO execute(UUID idCandidate){
        var candidate = this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UserNotFoundException("User not found");
        });
        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .email(candidate.getEmail())
                .id(candidate.getId())
                .name(candidate.getName())
                .description(candidate.getDescription())
                .username(candidate.getUsername())
                .build();
        return candidateDTO;

    }
}
