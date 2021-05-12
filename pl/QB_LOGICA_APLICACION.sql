CREATE OR REPLACE PACKAGE DAKERO.QB_LOGICA_APLICACION AS
TYPE vcrefcursor IS REF CURSOR;

PROCEDURE pl_val_usuario(VCUSU_USER      IN VARCHAR2 
                        ,VCUSU_PASS      IN VARCHAR2
						,CSCONSULTA		OUT vcrefcursor
                        ,VCESTADO_PROCESO       OUT VARCHAR2        
                        ,VCMENSAJE_PROCESO      OUT VARCHAR2       
);

PROCEDURE PL_VAL_TOKEN(VCTKN_TOKEN    		     IN VARCHAR2        
					  ,VCESTADO_PROCESO         OUT VARCHAR2        
                      ,VCMENSAJE_PROCESO        OUT VARCHAR2        
				      );
END;
/
create or replace PACKAGE BODY  DAKERO.QB_LOGICA_APLICACION AS

PROCEDURE pl_val_usuario(VCUSU_USER      IN VARCHAR2 
                        ,VCUSU_PASS      IN VARCHAR2
						,CSCONSULTA		OUT vcrefcursor
                        ,VCESTADO_PROCESO       OUT VARCHAR2        
                        ,VCMENSAJE_PROCESO      OUT VARCHAR2        
)IS
    nmusu_id NUMBER:=0;
BEGIN
 
  SELECT USU_ID
    INTO nmusu_id
    FROM USUARIO
   WHERE USU_USER = VCUSU_USER
     AND USU_PASS = qb_util.FB_ENCRIPTAR(VCUSU_PASS);
  
   IF nmusu_id=0 THEN 
      VCESTADO_PROCESO  := 'N';
      VCMENSAJE_PROCESO := 'usuario o contraseña incorrectos'; 
	  RETURN;
   END IF;
   
    OPEN csconsulta for 
	   SELECT * 
	     FROM TOKEN 
	    WHERE USU_ID =nmusu_id;
    VCESTADO_PROCESO  := 'S';
    VCMENSAJE_PROCESO := 'Usuario ingresado con exito.';
EXCEPTION
WHEN OTHERS THEN
    VCESTADO_PROCESO  := 'N';
    VCMENSAJE_PROCESO := 'Error en pl_val_usuario'||sqlerrm;
END pl_val_usuario;

PROCEDURE PL_VAL_TOKEN(VCTKN_TOKEN      		 IN VARCHAR2        
					  ,VCESTADO_PROCESO         OUT VARCHAR2        
                      ,VCMENSAJE_PROCESO        OUT VARCHAR2        
				      )IS
	nmValida   NUMBER;
BEGIN
	BEGIN
	   SELECT COUNT(*)
		 INTO nmValida
		 FROM TOKEN	  
		WHERE TKN_token =vcTKN_token;
	EXCEPTION 
	WHEN OTHERS	THEN
		nmValida:=0;
	END; 
	 IF nmValida= 0 THEN
		VCESTADO_PROCESO  :='N';
		VCMENSAJE_PROCESO :='Token Incorrecto';
		RETURN;
	 END IF;
	 
	 VCESTADO_PROCESO  :='S';
	 VCMENSAJE_PROCESO :='Token Valido';
EXCEPTION
WHEN OTHERS THEN
    VCESTADO_PROCESO  := 'N';
    VCMENSAJE_PROCESO := 'Error en pl_val_token'||sqlerrm;
END pl_val_token;

					  

END QB_LOGICA_APLICACION;

