package mindswap.porto.RentACar.service;

import mindswap.porto.RentACar.converter.ClientConverter;
import mindswap.porto.RentACar.dto.client.ClientCreateDto;
import mindswap.porto.RentACar.dto.client.ClientGetDto;
import mindswap.porto.RentACar.dto.client.ClientUpdateDto;
import mindswap.porto.RentACar.exceptions.clientexceptions.*;
import mindswap.porto.RentACar.model.Client;
import mindswap.porto.RentACar.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
@ExtendWith(SpringExtension.class)
class ClientServiceTestMockito {

    @MockBean
    private ClientRepository clientRepositoryMock;
    private ClientService clientService;
    static MockedStatic<ClientConverter> mockedClientConverter = Mockito.mockStatic(ClientConverter.class);

    @BeforeEach
    public void setUp() {
        clientService = new ClientService(clientRepositoryMock);
    }

    @Test
    void testCreateClientCallsRepositoryAndConverter() throws ClientAlreadyExists, NifException, EmailException, LicenceException {
        //given
        ClientCreateDto clientCreateDto = new ClientCreateDto("João", 123456789, LocalDate.of(1990, 4, 22), "ABC123DEF", "joao@mindera.pt");
        Client client = new Client("João", 123456789, LocalDate.of(1990, 4, 22), "ABC123DEF", "joao@mindera.pt");
        when(clientRepositoryMock.findByNif(clientCreateDto.nif())).thenReturn(Optional.empty());
        mockedClientConverter.when(() -> ClientConverter.dtoToClient(clientCreateDto)).thenReturn(client);
        when(clientRepositoryMock.save(Mockito.any())).thenReturn(client);

        //when
        clientService.add(clientCreateDto);

        //then
        verify(clientRepositoryMock, times(1)).findByNif(clientCreateDto.nif());
        mockedClientConverter.verify(() -> ClientConverter.dtoToClient(clientCreateDto));
        mockedClientConverter.verifyNoMoreInteractions();

        verify(clientRepositoryMock, times(1)).save(client);
        Mockito.verifyNoMoreInteractions(clientRepositoryMock);
        assertEquals(client, clientService.add(clientCreateDto));
    }

    @Test
    void createClienttWithDuplicatedNifThrowsException() {
        //given
        ClientCreateDto clientCreateDto = new ClientCreateDto("João", 123456789, LocalDate.of(1990, 4, 22), "ABC123DEF", "joao@mindera.pt");

        //when
        when(clientRepositoryMock.findByNif(clientCreateDto.nif())).thenReturn(Optional.of(new Client()));
        //then
        assertThrows(NifException.class, () -> clientService.add(clientCreateDto));
        assertEquals("This nif is already been inserted", assertThrows(NifException.class, () -> clientService.add(clientCreateDto)).getMessage());

    }

    @Test
    void createClientConvertToDtoAndGetAll() throws ClientAlreadyExists, NifException, EmailException, LicenceException {
        List<Client> clientList = Arrays.asList(
                new Client("John", 123456789, LocalDate.of(1990, 4, 22), "ABC123DEF", "john@example.com"),
                new Client("Jane", 987654321, LocalDate.of(1985, 8, 15), "XYZ456ABC", "jane@example.com")
        );

        List<ClientGetDto> clientDtoList = Arrays.asList(
                new ClientGetDto("John", "john@example.com", 123456789),
                new ClientGetDto("Jane", "jane@example.com",987654321)
        );
        mockedClientConverter.when(() -> ClientConverter.clientToDtoList(clientList)).thenReturn(clientDtoList);
        when(clientRepositoryMock.findAll()).thenReturn(clientList);
        List<ClientGetDto> result = clientService.getAll();
        assertEquals(clientList.size(), result.size());

        verify(clientRepositoryMock, Mockito.times(1)).findAll();
    }

    @Test
    void createAndUpdateAClient() throws EmailException, ClientNotFoundException{
        Client clientToUpdate = Client.builder()
                .name("José")
                .nif(123456789)
                .birthDate(LocalDate.of(1990,04,22))
                .licence("ABC123DEF")
                .email("jose@mindera.pt")
                .build();

        ClientUpdateDto clientUpdateDto = ClientUpdateDto.builder()
                .email("joana@mindera.pt")
                .name("Joana")
                .build();
        when(clientRepositoryMock.findById(1L)).thenReturn(Optional.of(clientToUpdate));
        when(clientRepositoryMock.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());

        clientService.put(1L, clientUpdateDto);

        verify(clientRepositoryMock, times(1)).findById(1L);

        verify(clientRepositoryMock, times(1)).findByEmail(clientUpdateDto.email());

        verify(clientRepositoryMock, times(1)).save(clientToUpdate);
        verifyNoMoreInteractions(clientRepositoryMock);

        assertEquals(clientUpdateDto.name(), clientToUpdate.getName());
        assertEquals(clientUpdateDto.email(), clientToUpdate.getEmail());






    }
}