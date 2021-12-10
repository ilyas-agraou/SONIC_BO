package com.capgemini.candidateorganizationsystem.repositories;

import com.capgemini.candidateorganizationsystem.entities.CandidateEntity;
import com.capgemini.candidateorganizationsystem.entities.CandidateStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface CandidateRepository extends JpaRepository<CandidateEntity, Long>, JpaSpecificationExecutor<CandidateEntity> {

    public List<CandidateEntity> findByStatus(CandidateStatus status);

    @Query(value = "SELECT * FROM candidates c WHERE c.profile = 'FullStack' order by c.received_date",
            nativeQuery = true)
    List<CandidateEntity> findAllFullStackCandidatesNative();

    @Query(value = "SELECT * FROM candidates c WHERE c.profile = 'Testing' order by c.received_date",
            nativeQuery = true)
    List<CandidateEntity> findAllTestingCandidatesNative();

    @Query(value = "SELECT * FROM candidates c WHERE c.profile = 'SalesForce' order by c.received_date",
            nativeQuery = true)
    List<CandidateEntity> findAllSalesForceCandidatesNative();

    // Dashboard needed values , JPQL Requesting

    // Profiles
    @Query(value = "SELECT COUNT(c.id) FROM candidates c WHERE c.profile = 'FullStack'",
            nativeQuery = true)
    Long CalculateFullStackCandidatesNative();

    @Query(value = "SELECT COUNT(c.id) FROM candidates c WHERE c.profile = 'Testing'",
            nativeQuery = true)
    Long CalculateTestingCandidatesNative();

    @Query(value = "SELECT COUNT(c.id) FROM candidates c WHERE c.profile = 'SalesForce'",
            nativeQuery = true)
    Long CalculateSalesForceCandidatesNative();

    // Status
    @Query(value = "SELECT COUNT(c.id) FROM candidates c WHERE c.status = 'CURRENT'",
            nativeQuery = true)
    Long CalculateCurrentCandidatesNative();

    @Query(value = "SELECT COUNT(c.id) FROM candidates c WHERE c.status = 'ACCEPTED'",
            nativeQuery = true)
    Long CalculateAcceptedCandidatesNative();

    @Query(value = "SELECT COUNT(c.id) FROM candidates c WHERE c.status = 'REJECTED'",
            nativeQuery = true)
    Long CalculateRejectedCandidatesNative();

}
