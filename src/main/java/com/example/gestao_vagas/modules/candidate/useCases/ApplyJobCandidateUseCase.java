package com.example.gestao_vagas.modules.candidate.useCases;


import com.example.gestao_vagas.exceptions.JobNotFoundException;
import com.example.gestao_vagas.exceptions.UserNotFoundException;
import com.example.gestao_vagas.modules.candidate.CandidateRepository;
import com.example.gestao_vagas.modules.candidate.entity.ApplyJobEntity;
import com.example.gestao_vagas.modules.candidate.repository.ApplyJobRepository;
import com.example.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID idCandidate, UUID idJob){
        // validar se candidato existe
        this.candidateRepository.findById(idCandidate).orElseThrow(() -> new UserNotFoundException("User not found!"));

        // validar se a vaga existe
        this.jobRepository.findById(idJob).orElseThrow(() -> new JobNotFoundException("Job not found!"));

        // candidato pode se inscrever
        var applyJob = ApplyJobEntity.builder()
                        .candidateId(idCandidate)
                        .jobId(idJob)
                        .build();

        return applyJobRepository.save(applyJob);

    }
}
