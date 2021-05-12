package co.com.api.prueba.classabstract;

import co.com.activos.Utilidad.GestionRetornoObjeto;
import co.com.api.prueba.Entidad.Token;
import co.com.api.prueba.Interface.InterfaceTokenDao;
import co.com.api.prueba.Controller.TokenDao;
import java.util.List;

/**
 *
 * @author dakero
 */
public abstract class AbstractTokenDao {

    static InterfaceTokenDao tokenD = new TokenDao();

    public static GestionRetornoObjeto insertaToken(Token p_token) {
        return tokenD.insertaToken(p_token);
    }

    public static GestionRetornoObjeto actualizaToken(Token p_token) {
        return tokenD.actualizaToken(p_token);
    }

    public static GestionRetornoObjeto eliminaToken(Token p_token) {
        return tokenD.eliminaToken(p_token);
    }
    public static GestionRetornoObjeto validar_Token(Token p_token) {
        return tokenD.validar_Token(p_token);
    }

    public static List<Token> query_pk_Token(Token p_token) {
        return (List<Token>) tokenD.query_pk_Token(p_token).getObjetoRetorno();
    }

    public static List<Token> query_todos_Token() {
        return (List<Token>) tokenD.query_todos_Token().getObjetoRetorno();
    }

}
