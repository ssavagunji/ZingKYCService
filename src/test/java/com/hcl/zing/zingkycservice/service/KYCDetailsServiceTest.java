package com.hcl.zing.zingkycservice.service;

import com.hcl.zing.zingkycservice.dto.KYCDetailsDTO;
import com.hcl.zing.zingkycservice.entitiy.KYCDetails;
import com.hcl.zing.zingkycservice.exception.ValueNotFoundException;
import com.hcl.zing.zingkycservice.mapper.KYCDetailsMapper;
import com.hcl.zing.zingkycservice.repository.KYCRepository;
import com.hcl.zing.zingkycservice.repository.UserRepository;
import com.hcl.zing.zingkycservice.services.KYCDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class KYCDetailsServiceTest {

    @Mock
    private KYCRepository kycRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private KYCDetailsService kycDetailsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveKYCDetails() {
        KYCDetailsDTO kycDetailsDTO = new KYCDetailsDTO();
        KYCDetails kycDetails = KYCDetailsMapper.toEntity(kycDetailsDTO);
        when(kycRepository.save(kycDetails)).thenReturn(kycDetails);

        KYCDetailsDTO savedKYCDetailsDTO = kycDetailsService.saveKYCDetails(kycDetailsDTO);

        assertEquals(kycDetailsDTO, savedKYCDetailsDTO);
        verify(userRepository, times(1)).save(kycDetails.getUserDetail());
        verify(kycRepository, times(1)).save(kycDetails);
    }

    @Test
    public void testGetKYCDetailsById_WhenIdExists() {
        Long id = 1L;
        KYCDetails kycDetails = new KYCDetails();
        kycDetails.setId(id);
        Optional<KYCDetails> optionalKYCDetails = Optional.of(kycDetails);
        when(kycRepository.findById(id)).thenReturn(optionalKYCDetails);

        KYCDetailsDTO retrievedKYCDetailsDTO = kycDetailsService.getKYCDetailsById(id);

        assertEquals(KYCDetailsMapper.toDTO(kycDetails), retrievedKYCDetailsDTO);
    }

    @Test
    public void testGetKYCDetailsById_WhenIdDoesNotExist() {
        Long id = 1L;
        when(kycRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ValueNotFoundException.class, () -> kycDetailsService.getKYCDetailsById(id));
    }



    @Test
    public void testUpdateKYCDetails() {
        KYCDetailsDTO kycDetailsDTO = new KYCDetailsDTO();
        KYCDetails kycDetails = KYCDetailsMapper.toEntity(kycDetailsDTO);
        when(kycRepository.save(kycDetails)).thenReturn(kycDetails);

        assertDoesNotThrow(() -> kycDetailsService.updateKYCDetails(kycDetailsDTO));
    }

    @Test
    public void testDeleteKYCDetails() {
        Long id = 1L;
        assertDoesNotThrow(() -> kycDetailsService.deleteKYCDetails(id));
        verify(kycRepository, times(1)).deleteById(id);
    }
}

