import com.dh.Checkpoint_I.config.ConfiguracaoJDBC;
import com.dh.Checkpoint_I.dao.impl.DentistaDao;
import com.dh.Checkpoint_I.model.Dentista;
import com.dh.Checkpoint_I.service.DentistaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class DentistaServiceTest {
    private DentistaService dentistaService = new DentistaService(new DentistaDao(new ConfiguracaoJDBC()));

    private Dentista dentista;

    @BeforeEach
    void doBefore() {
        dentista = new Dentista("1", "Roberto", "Souza");

    }
    @Test
    void deveAdicionarDentista () throws SQLException {
        dentistaService.adicionar(dentista);

        Assertions.assertNotNull(dentista.getMatriculaCadastro());
    }


}
