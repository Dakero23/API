CREATE OR REPLACE PACKAGE DAKERO.QB_CRUD_APLICACION AS

TYPE vcrefcursor IS REF CURSOR;

PROCEDURE pl_ins_empresa(
                         nmemp_id                                           IN OUT NUMBER,
                         vctip_doc                                          IN VARCHAR2,
                         nmemp_doc                                          IN NUMBER,
                         vcemp_nom                                          IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_empresa(
                         nmemp_id                                           IN NUMBER,
                         vctip_doc                                          IN VARCHAR2,
                         nmemp_doc                                          IN NUMBER,
                         vcemp_nom                                          IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_empresa(
                         nmemp_id                                           IN NUMBER,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_empresa(
                         nmemp_id                                           IN NUMBER,
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_empresa(
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_ins_tipo_documento(
                                vctip_doc                                          IN OUT VARCHAR2,
                                vctip_nombre                                       IN VARCHAR2,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_tipo_documento(
                                vctip_doc                                          IN VARCHAR2,
                                vctip_nombre                                       IN VARCHAR2,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_tipo_documento(
                                vctip_doc                                          IN VARCHAR2,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_tipo_documento(
                                vctip_doc                                          IN VARCHAR2,
                                csconsulta                                         OUT VCREFCURSOR,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_tipo_documento(
                                csconsulta                                         OUT VCREFCURSOR,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_ins_informacion_basica(
                                    nminb_id                                           IN OUT NUMBER,
                                    vctip_doc                                          IN VARCHAR2,
                                    nminb_documento                                    IN NUMBER,
                                    vcinb_nombre                                       IN VARCHAR2,
                                    vcinb_apellido                                     IN VARCHAR2,
                                    vcinb_correo                                       IN VARCHAR2,
                                    nminb_celular                                      IN NUMBER,
                                    nminb_telefono                                     IN NUMBER,
                                    vcinb_direccion                                    IN VARCHAR2,
                                    vcaud_usuario                                      IN VARCHAR2,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_informacion_basica(
                                    nminb_id                                           IN NUMBER,
                                    vctip_doc                                          IN VARCHAR2,
                                    nminb_documento                                    IN NUMBER,
                                    vcinb_nombre                                       IN VARCHAR2,
                                    vcinb_apellido                                     IN VARCHAR2,
                                    vcinb_correo                                       IN VARCHAR2,
                                    nminb_celular                                      IN NUMBER,
                                    nminb_telefono                                     IN NUMBER,
                                    vcinb_direccion                                    IN VARCHAR2,
                                    vcaud_usuario                                      IN VARCHAR2,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_informacion_basica(
                                    nminb_id                                           IN NUMBER,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_informacion_basica(
                                    nminb_id                                           IN NUMBER,
                                    csconsulta                                         OUT VCREFCURSOR,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_informacion_basica(
                                    csconsulta                                         OUT VCREFCURSOR,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_ins_tipo_usuario(
                              nmtpu_id                                           IN OUT NUMBER,
                              vctpu_descripcion                                  IN VARCHAR2,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_tipo_usuario(
                              nmtpu_id                                           IN NUMBER,
                              vctpu_descripcion                                  IN VARCHAR2,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_tipo_usuario(
                              nmtpu_id                                           IN NUMBER,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_tipo_usuario(
                              nmtpu_id                                           IN NUMBER,
                              csconsulta                                         OUT VCREFCURSOR,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_tipo_usuario(
                              csconsulta                                         OUT VCREFCURSOR,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_ins_usuario(
                         nmusu_id                                           IN OUT NUMBER,
                         nminb_id                                           IN NUMBER,
                         nmtpu_id                                           IN NUMBER,
                         nmemp_id                                           IN NUMBER,
                         vcusu_user                                         IN VARCHAR2,
                         vcusu_pass                                         IN VARCHAR2,
                         vcaud_usuario                                      IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_usuario(
                         nmusu_id                                           IN NUMBER,
                         nminb_id                                           IN NUMBER,
                         nmtpu_id                                           IN NUMBER,
                         nmemp_id                                           IN NUMBER,
                         vcusu_user                                         IN VARCHAR2,
                         vcusu_pass                                         IN VARCHAR2,
                         vcaud_usuario                                      IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_usuario(
                         nmusu_id                                           IN NUMBER,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_usuario(
                         nmusu_id                                           IN NUMBER,
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_usuario(
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_ins_tipo_tarjeta(
                              nmttj_id                                           IN OUT NUMBER,
                              vcttj_nombre                                       IN VARCHAR2,
                              vcaud_usuario                                      IN VARCHAR2,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_tipo_tarjeta(
                              nmttj_id                                           IN NUMBER,
                              vcttj_nombre                                       IN VARCHAR2,
                              vcaud_usuario                                      IN VARCHAR2,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_tipo_tarjeta(
                              nmttj_id                                           IN NUMBER,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_tipo_tarjeta(
                              nmttj_id                                           IN NUMBER,
                              csconsulta                                         OUT VCREFCURSOR,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_tipo_tarjeta(
                              csconsulta                                         OUT VCREFCURSOR,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_ins_tarjeta(
                         nmtar_id                                           IN OUT NUMBER,
                         nmttj_id                                           IN NUMBER,
                         nmusu_id                                           IN NUMBER,
                         nmtar_numero                                       IN NUMBER,
                         vctar_nombre                                       IN VARCHAR2,
                         vctar_fec_exp                                      IN VARCHAR2,
                         nmtar_cod_seg                                      IN NUMBER,
                         vcaud_usuario                                      IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_tarjeta(
                         nmtar_id                                           IN NUMBER,
                         nmttj_id                                           IN NUMBER,
                         nmusu_id                                           IN NUMBER,
                         nmtar_numero                                       IN NUMBER,
                         vctar_nombre                                       IN VARCHAR2,
                         vctar_fec_exp                                      IN VARCHAR2,
                         nmtar_cod_seg                                      IN NUMBER,
                         vcaud_usuario                                      IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_tarjeta(
                         nmtar_id                                           IN NUMBER,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_tarjeta(
                         nmtar_id                                           IN NUMBER,
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_tarjeta(
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_ins_servicios(
                           nmsrv_id                                           IN OUT NUMBER,
                           vcsrv_nombre                                       IN VARCHAR2,
                           vcsrv_descripcion                                  IN VARCHAR2,
                           dtsrv_fec_vig                                      IN DATE,
                           vcsrv_version                                      IN VARCHAR2,
                           vcaud_usuario                                      IN VARCHAR2,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_servicios(
                           nmsrv_id                                           IN NUMBER,
                           vcsrv_nombre                                       IN VARCHAR2,
                           vcsrv_descripcion                                  IN VARCHAR2,
                           dtsrv_fec_vig                                      IN DATE,
                           vcsrv_version                                      IN VARCHAR2,
                           vcaud_usuario                                      IN VARCHAR2,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_servicios(
                           nmsrv_id                                           IN NUMBER,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_servicios(
                           nmsrv_id                                           IN NUMBER,
                           csconsulta                                         OUT VCREFCURSOR,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_servicios(
                           csconsulta                                         OUT VCREFCURSOR,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_ins_token(
                       nmtkn_id                                           IN OUT NUMBER,
                       nmusu_id                                           IN NUMBER,
                       vctkn_token                                        IN VARCHAR2,
                       dttkn_fec_vig                                      IN DATE,
                       vcaud_usuario                                      IN VARCHAR2,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_token(
                       nmtkn_id                                           IN NUMBER,
                       nmusu_id                                           IN NUMBER,
                       vctkn_token                                        IN VARCHAR2,
                       dttkn_fec_vig                                      IN DATE,
                       vcaud_usuario                                      IN VARCHAR2,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_token(
                       nmtkn_id                                           IN NUMBER,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_token(
                       nmtkn_id                                           IN NUMBER,
                       csconsulta                                         OUT VCREFCURSOR,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_token(
                       csconsulta                                         OUT VCREFCURSOR,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_ins_servicios_token(
                                 nmsrt_id                                           IN OUT NUMBER,
                                 nmtkn_id                                           IN NUMBER,
                                 nmsrv_id                                           IN NUMBER,
                                 vcsrt_estado                                       IN CHAR,
                                 vcaud_usuario                                      IN VARCHAR2,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_upd_servicios_token(
                                 nmsrt_id                                           IN NUMBER,
                                 nmtkn_id                                           IN NUMBER,
                                 nmsrv_id                                           IN NUMBER,
                                 vcsrt_estado                                       IN CHAR,
                                 vcaud_usuario                                      IN VARCHAR2,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_del_servicios_token(
                                 nmsrt_id                                           IN NUMBER,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_qpk_servicios_token(
                                 nmsrt_id                                           IN NUMBER,
                                 csconsulta                                         OUT VCREFCURSOR,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2);

PROCEDURE pl_all_servicios_token(
                                 csconsulta                                         OUT VCREFCURSOR,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2);

END QB_CRUD_APLICACION;
/
CREATE OR REPLACE PACKAGE BODY DAKERO.QB_CRUD_APLICACION AS


 PROCEDURE pl_ins_empresa(
                         nmemp_id                                           IN OUT NUMBER,
                         vctip_doc                                          IN VARCHAR2,
                         nmemp_doc                                          IN NUMBER,
                         vcemp_nom                                          IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 

BEGIN 

SELECT MAX(NVL(EMP_ID,0)+1) INTO nmEMP_ID  FROM DAKERO.EMPRESA;

	begin 
		insert into DAKERO.EMPRESA
		( emp_id
		 ,tip_doc
		 ,emp_doc
		 ,emp_nom
		)values( 
		  nmEMP_ID
		 ,vctip_doc
		 ,nmemp_doc
		 ,vcemp_nom
		); 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente.'; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.EMPRESA: '||sqlerrm; 
	end; 
	-- 
end pl_ins_empresa;


PROCEDURE pl_upd_empresa(
                         nmemp_id                                           IN NUMBER,
                         vctip_doc                                          IN VARCHAR2,
                         nmemp_doc                                          IN NUMBER,
                         vcemp_nom                                          IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
						 
 nmValida   NUMBER;
BEGIN 

	BEGIN
		SELECT COUNT(*)
		  INTO nmValida    
		  FROM DAKERO.empresa
		 WHERE emp_id 	=	nmemp_id;
	EXCEPTION
	WHEN OTHERS THEN
		nmValida    := 0;
	END;

	IF nmValida= 0 THEN
		vcestado_proceso   := 'N'; 
		vcmensaje_proceso  := 'Empresa no encontrada, no se realiza actualizaciòn'; 
		RETURN;
	END IF;

	begin 
		update DAKERO.EMPRESA
		set	tip_doc                            	=	vctip_doc,
		   	emp_doc                            	=	nmemp_doc,
		   	emp_nom                            	=	vcemp_nom
		where	emp_id                         	=	nmemp_id;
		commit; 
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.EMPRESA: '||sqlerrm; 
	end; 
	-- 
end pl_upd_empresa;

PROCEDURE pl_del_empresa(
                         nmemp_id                                           IN NUMBER,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.EMPRESA
	where		emp_id                             	=	nmemp_id;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.EMPRESA: '||sqlerrm; 
end pl_del_empresa;

PROCEDURE pl_qpk_empresa(
                         nmemp_id                                           IN NUMBER,
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.EMPRESA 
			where	emp_id                         	=	nmemp_id;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.EMPRESA: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_empresa;

PROCEDURE pl_all_empresa(
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.EMPRESA 
			order by emp_id;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.EMPRESA: '||sqlerrm; 
	end; 
	-- 
end pl_all_empresa;


 PROCEDURE pl_ins_tipo_documento(
                                vctip_doc                                          IN OUT VARCHAR2,
                                vctip_nombre                                       IN VARCHAR2,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
 nmTIP_DOC NUMBER;
BEGIN 

SELECT MAX(NVL(TIP_DOC,0)+1) INTO nmTIP_DOC  FROM DAKERO.TIPO_DOCUMENTO;

	begin 
		insert into DAKERO.TIPO_DOCUMENTO
		( tip_doc
		 ,tip_nombre
		)values( 
		  nmTIP_DOC
		 ,vctip_nombre
		); 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente.'; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.TIPO_DOCUMENTO: '||sqlerrm; 
	end; 
	-- 
end pl_ins_tipo_documento;


PROCEDURE pl_upd_tipo_documento(
                                vctip_doc                                          IN VARCHAR2,
                                vctip_nombre                                       IN VARCHAR2,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
                                
nmValida  NUMBER;
BEGIN 

	BEGIN
		SELECT COUNT(*)
		  INTO nmValida    
		  FROM DAKERO.TIPO_DOCUMENTO
		 WHERE tip_doc 	=	vctip_doc;
	EXCEPTION
	WHEN OTHERS THEN
		nmValida    := 0;
	END;

	IF nmValida= 0 THEN
		vcestado_proceso   := 'N'; 
		vcmensaje_proceso  := 'tipo documento no encontrado, no se realizo la actualizaciòn.'; 
		RETURN;
	END IF;

	begin 
		update DAKERO.TIPO_DOCUMENTO
		set	tip_nombre                         	=	vctip_nombre
		where	tip_doc                        	=	vctip_doc;
		commit; 
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.TIPO_DOCUMENTO: '||sqlerrm; 
	end; 
	-- 
end pl_upd_tipo_documento;

PROCEDURE pl_del_tipo_documento(
                                vctip_doc                                          IN VARCHAR2,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.TIPO_DOCUMENTO
	where		tip_doc                            	=	vctip_doc;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.TIPO_DOCUMENTO: '||sqlerrm; 
end pl_del_tipo_documento;

PROCEDURE pl_qpk_tipo_documento(
                                vctip_doc                                          IN VARCHAR2,
                                csconsulta                                         OUT VCREFCURSOR,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TIPO_DOCUMENTO 
			where	tip_doc       =	vctip_doc;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TIPO_DOCUMENTO: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_tipo_documento;

PROCEDURE pl_all_tipo_documento(
                                csconsulta                                         OUT VCREFCURSOR,
                                vcestado_proceso                                   IN OUT VARCHAR2,
                                vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TIPO_DOCUMENTO 
			order by tip_doc;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TIPO_DOCUMENTO: '||sqlerrm; 
	end; 
	-- 
end pl_all_tipo_documento;


 PROCEDURE pl_ins_informacion_basica(
                                    nminb_id                                           IN OUT NUMBER,
                                    vctip_doc                                          IN VARCHAR2,
                                    nminb_documento                                    IN NUMBER,
                                    vcinb_nombre                                       IN VARCHAR2,
                                    vcinb_apellido                                     IN VARCHAR2,
                                    vcinb_correo                                       IN VARCHAR2,
                                    nminb_celular                                      IN NUMBER,
                                    nminb_telefono                                     IN NUMBER,
                                    vcinb_direccion                                    IN VARCHAR2,
                                    vcaud_usuario                                      IN VARCHAR2,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2) IS 

BEGIN 

SELECT MAX(NVL(INB_ID,0)+1) INTO nmINB_ID  FROM DAKERO.INFORMACION_BASICA;

	begin 
		insert into DAKERO.INFORMACION_BASICA
		( inb_id
		 ,tip_doc
		 ,inb_documento
		 ,inb_nombre
		 ,inb_apellido
		 ,inb_correo
		 ,inb_celular
		 ,inb_telefono
		 ,inb_direccion
		 ,aud_fecha
		 ,aud_usuario
		)values( 
		  nmINB_ID
		 ,vctip_doc
		 ,nminb_documento
		 ,vcinb_nombre
		 ,vcinb_apellido
		 ,vcinb_correo
		 ,nminb_celular
		 ,nminb_telefono
		 ,vcinb_direccion
		 ,SYSDATE
		 ,vcaud_usuario
		); 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente.'; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.INFORMACION_BASICA: '||sqlerrm; 
	end; 
	-- 
end pl_ins_informacion_basica;


PROCEDURE pl_upd_informacion_basica(
                                    nminb_id                                           IN NUMBER,
                                    vctip_doc                                          IN VARCHAR2,
                                    nminb_documento                                    IN NUMBER,
                                    vcinb_nombre                                       IN VARCHAR2,
                                    vcinb_apellido                                     IN VARCHAR2,
                                    vcinb_correo                                       IN VARCHAR2,
                                    nminb_celular                                      IN NUMBER,
                                    nminb_telefono                                     IN NUMBER,
                                    vcinb_direccion                                    IN VARCHAR2,
                                    vcaud_usuario                                      IN VARCHAR2,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
nmValida  NUMBER;
BEGIN 

	BEGIN
		SELECT COUNT(*)
		  INTO nmValida    
		  FROM DAKERO.INFORMACION_BASICA
		 WHERE INB_ID 	=	nmINB_ID;
	EXCEPTION
	WHEN OTHERS THEN
		nmValida    := 0;
	END;

	IF nmValida= 0 THEN
		vcestado_proceso   := 'N'; 
		vcmensaje_proceso  := 'No se actualizo la informacion basica identificador erroneo.'; 
		RETURN;
	END IF;

	begin 
		update DAKERO.INFORMACION_BASICA
		set	tip_doc                            	=	vctip_doc,
		   	inb_documento                      	=	nminb_documento,
		   	inb_nombre                         	=	vcinb_nombre,
		   	inb_apellido                       	=	vcinb_apellido,
		   	inb_correo                         	=	vcinb_correo,
		   	inb_celular                        	=	nminb_celular,
		   	inb_telefono                       	=	nminb_telefono,
		   	inb_direccion                      	=	vcinb_direccion,
		   	aud_fecha                          	=	SYSDATE,
		   	aud_usuario                        	=	vcaud_usuario
		where	inb_id                         	=	nminb_id;
		commit; 
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.INFORMACION_BASICA: '||sqlerrm; 
	end; 
	-- 
end pl_upd_informacion_basica;

PROCEDURE pl_del_informacion_basica(
                                    nminb_id                                           IN NUMBER,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.INFORMACION_BASICA
	where		inb_id                             	=	nminb_id;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.INFORMACION_BASICA: '||sqlerrm; 
end pl_del_informacion_basica;

PROCEDURE pl_qpk_informacion_basica(
                                    nminb_id                                           IN NUMBER,
                                    csconsulta                                         OUT VCREFCURSOR,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.INFORMACION_BASICA 
			where	inb_id                         	=	nminb_id;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.INFORMACION_BASICA: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_informacion_basica;

PROCEDURE pl_all_informacion_basica(
                                    csconsulta                                         OUT VCREFCURSOR,
                                    vcestado_proceso                                   IN OUT VARCHAR2,
                                    vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.INFORMACION_BASICA 
			order by inb_id;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.INFORMACION_BASICA: '||sqlerrm; 
	end; 
	-- 
end pl_all_informacion_basica;


 PROCEDURE pl_ins_tipo_usuario(
                              nmtpu_id                                           IN OUT NUMBER,
                              vctpu_descripcion                                  IN VARCHAR2,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 

BEGIN 

  SELECT MAX(NVL(TPU_ID,0)+1) 
    INTO nmTPU_ID 
    FROM DAKERO.TIPO_USUARIO;

	BEGIN 
		INSERT INTO DAKERO.TIPO_USUARIO
		( tpu_id
		 ,tpu_descripcion
		)values( 
		  nmTPU_ID
		 ,vctpu_descripcion
		); 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente.'; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.TIPO_USUARIO: '||sqlerrm; 
	end; 
	-- 
end pl_ins_tipo_usuario;


PROCEDURE pl_upd_tipo_usuario(
                              nmtpu_id                                           IN NUMBER,
                              vctpu_descripcion                                  IN VARCHAR2,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
nmValida  NUMBER;
BEGIN 
	
	BEGIN
		SELECT COUNT(*)
		  INTO nmValida    
		  FROM DAKERO.TIPO_USUARIO
		 WHERE tpu_id 	=	nmtpu_id;
	EXCEPTION
	WHEN OTHERS THEN
		nmValida    := 0;
	END;

	IF nmValida= 0 THEN
		vcestado_proceso   := 'N'; 
		vcmensaje_proceso  := 'Tipo Usuario no encontrado no se pudo actualizar'; 
		RETURN;
	END IF;

	begin 
		update DAKERO.TIPO_USUARIO
		set	tpu_descripcion                    	=	vctpu_descripcion
		where	tpu_id                         	=	nmtpu_id;
		commit; 
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.TIPO_USUARIO: '||sqlerrm; 
	end; 
	-- 
end pl_upd_tipo_usuario;

PROCEDURE pl_del_tipo_usuario(
                              nmtpu_id                                           IN NUMBER,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.TIPO_USUARIO
	where		tpu_id                             	=	nmtpu_id;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.TIPO_USUARIO: '||sqlerrm; 
end pl_del_tipo_usuario;

PROCEDURE pl_qpk_tipo_usuario(
                              nmtpu_id                                           IN NUMBER,
                              csconsulta                                         OUT VCREFCURSOR,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TIPO_USUARIO 
			where	tpu_id                         	=	nmtpu_id;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TIPO_USUARIO: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_tipo_usuario;

PROCEDURE pl_all_tipo_usuario(
                              csconsulta                                         OUT VCREFCURSOR,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TIPO_USUARIO 
			order by tpu_id;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TIPO_USUARIO: '||sqlerrm; 
	end; 
	-- 
end pl_all_tipo_usuario;


 PROCEDURE pl_ins_usuario(
                         nmusu_id                                           IN OUT NUMBER,
                         nminb_id                                           IN NUMBER,
                         nmtpu_id                                           IN NUMBER,
                         nmemp_id                                           IN NUMBER,
                         vcusu_user                                         IN VARCHAR2,
                         vcusu_pass                                         IN VARCHAR2,
                         vcaud_usuario                                      IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 

BEGIN 
 --Agregado a trigger
  /*SELECT MAX(NVL(USU_ID,0)+1) 
    INTO nmUSU_ID  
	FROM DAKERO.USUARIO;
*/
	begin 
		insert into DAKERO.USUARIO
		( inb_id
		 ,tpu_id
		 ,emp_id
		 ,usu_user
		 ,usu_pass
		 ,aud_fecha
		 ,aud_usuario
		)values( 
		  nminb_id
		 ,nmtpu_id
		 ,nmemp_id
		 ,vcusu_user
		 ,QB_UTIL.FB_ENCRIPTAR(vcusu_pass)
		 ,SYSDATE
		 ,vcaud_usuario
		) RETURNING usu_id into nmUSU_ID; 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente identificador.'||nmUSU_ID; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.USUARIO: '||sqlerrm; 
	end; 
	-- 
end pl_ins_usuario;


PROCEDURE pl_upd_usuario(
                         nmusu_id                                           IN NUMBER,
                         nminb_id                                           IN NUMBER,
                         nmtpu_id                                           IN NUMBER,
                         nmemp_id                                           IN NUMBER,
                         vcusu_user                                         IN VARCHAR2,
                         vcusu_pass                                         IN VARCHAR2,
                         vcaud_usuario                                      IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
nmValida     NUMBER;
BEGIN 
	
	BEGIN
		SELECT COUNT(*)
		  INTO nmValida    
		  FROM DAKERO.USUARIO
		 WHERE usu_id 	=	nmusu_id;
	EXCEPTION
	WHEN OTHERS THEN
		nmValida    := 0;
	END;

	IF nmValida= 0 THEN
		vcestado_proceso   := 'N'; 
		vcmensaje_proceso  := 'Usuario no encontrado'; 
		RETURN;
	END IF;
	
	update DAKERO.USUARIO
	set	inb_id        	=	nminb_id,
		tpu_id        	=	nmtpu_id,
		emp_id        	=	nmemp_id,
		usu_user      	=	vcusu_user,
		usu_pass      	=	QB_UTIL.FB_ENCRIPTAR(vcusu_pass),
		aud_fecha     	=	SYSDATE,
		aud_usuario   	=	vcaud_usuario
	where	usu_id    	=	nmusu_id;
	commit; 
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
EXCEPTION 
WHEN OTHERS THEN 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.USUARIO: '||sqlerrm; 
	-- 
end pl_upd_usuario;

PROCEDURE pl_del_usuario(
                         nmusu_id                                           IN NUMBER,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.USUARIO
	where	usu_id                             	=	nmusu_id;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.USUARIO: '||sqlerrm; 
end pl_del_usuario;

PROCEDURE pl_qpk_usuario(
                         nmusu_id                                           IN NUMBER,
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
	nmValida NUMBER;
BEGIN 
	begin 
		SELECT COUNT(*)
		  INTO nmValida
		  FROM DAKERO.USUARIO
		  where	usu_id  =	nmusu_id;
	exception 
		when others then 
			nmValida := 0;
	END;
	IF nmValida = 0 THEN
		vcestado_proceso  :='N';
		vcmensaje_proceso :='Usuario no encontrado identificador: '||nmUSU_ID;
		RETURN;
	END IF;

	begin 
		open csconsulta for 
			select * 
			from DAKERO.USUARIO 
			where	usu_id                         	=	nmusu_id;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.USUARIO: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_usuario;

PROCEDURE pl_all_usuario(
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.USUARIO 
			order by usu_id;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.USUARIO: '||sqlerrm; 
	end; 
	-- 
end pl_all_usuario;


 PROCEDURE pl_ins_tipo_tarjeta(
                              nmttj_id                                           IN OUT NUMBER,
                              vcttj_nombre                                       IN VARCHAR2,
                              vcaud_usuario                                      IN VARCHAR2,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 

BEGIN 

--SELECT MAX(NVL(TTJ_ID,0)+1) INTO nmTTJ_ID  FROM DAKERO.TIPO_TARJETA;

	begin 
		insert into DAKERO.TIPO_TARJETA
		( 
		  ttj_nombre
		 ,aud_fecha
		 ,aud_usuario
		)values( 
		  vcttj_nombre
		 ,SYSDATE
		 ,vcaud_usuario
		) RETURNING ttj_id into nmTTJ_ID; 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente.'||nmTTJ_ID; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.TIPO_TARJETA: '||sqlerrm; 
	end; 
	-- 
end pl_ins_tipo_tarjeta;


PROCEDURE pl_upd_tipo_tarjeta(
                              nmttj_id                                           IN NUMBER,
                              vcttj_nombre                                       IN VARCHAR2,
                              vcaud_usuario                                      IN VARCHAR2,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
nmValida  NUMBER;
BEGIN 

	BEGIN
		SELECT COUNT(*)
		  INTO nmValida    
		  FROM DAKERO.TIPO_TARJETA
		 WHERE TTJ_id 	=	nmTTJ_id;
	EXCEPTION
	WHEN OTHERS THEN
		nmValida    := 0;
	END;

	IF nmValida= 0 THEN
		vcestado_proceso   := 'N'; 
		vcmensaje_proceso  := 'TIPO_TARJETA no encontrada'; 
		RETURN;
	END IF;

	begin 
		update DAKERO.TIPO_TARJETA
		set	ttj_nombre                         	=	vcttj_nombre,
		   	aud_fecha                          	=	SYSDATE,
		   	aud_usuario                        	=	vcaud_usuario
		where	ttj_id                         	=	nmttj_id;
		commit; 
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.TIPO_TARJETA: '||sqlerrm; 
	end; 
	-- 
end pl_upd_tipo_tarjeta;

PROCEDURE pl_del_tipo_tarjeta(
                              nmttj_id                                           IN NUMBER,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.TIPO_TARJETA
	where		ttj_id                             	=	nmttj_id;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.TIPO_TARJETA: '||sqlerrm; 
end pl_del_tipo_tarjeta;

PROCEDURE pl_qpk_tipo_tarjeta(
                              nmttj_id                                           IN NUMBER,
                              csconsulta                                         OUT VCREFCURSOR,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TIPO_TARJETA 
			where	ttj_id                         	=	nmttj_id;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TIPO_TARJETA: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_tipo_tarjeta;

PROCEDURE pl_all_tipo_tarjeta(
                              csconsulta                                         OUT VCREFCURSOR,
                              vcestado_proceso                                   IN OUT VARCHAR2,
                              vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TIPO_TARJETA 
			order by ttj_id;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TIPO_TARJETA: '||sqlerrm; 
	end; 
	-- 
end pl_all_tipo_tarjeta;


 PROCEDURE pl_ins_tarjeta(
                         nmtar_id                                           IN OUT NUMBER,
                         nmttj_id                                           IN NUMBER,
                         nmusu_id                                           IN NUMBER,
                         nmtar_numero                                       IN NUMBER,
                         vctar_nombre                                       IN VARCHAR2,
                         vctar_fec_exp                                      IN VARCHAR2,
                         nmtar_cod_seg                                      IN NUMBER,
                         vcaud_usuario                                      IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 

BEGIN 

SELECT MAX(NVL(TAR_ID,0)+1) INTO nmTAR_ID  FROM DAKERO.TARJETA;

	begin 
		insert into DAKERO.TARJETA
		( tar_id
		 ,ttj_id
		 ,usu_id
		 ,tar_numero
		 ,tar_nombre
		 ,tar_fec_exp
		 ,tar_cod_seg
		 ,aud_fecha
		 ,aud_usuario
		)values( 
		  nmTAR_ID
		 ,nmttj_id
		 ,nmusu_id
		 ,nmtar_numero
		 ,vctar_nombre
		 ,vctar_fec_exp
		 ,nmtar_cod_seg
		 ,SYSDATE
		 ,vcaud_usuario
		); 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente.'; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.TARJETA: '||sqlerrm; 
	end; 
	-- 
end pl_ins_tarjeta;


PROCEDURE pl_upd_tarjeta(
                         nmtar_id                                           IN NUMBER,
                         nmttj_id                                           IN NUMBER,
                         nmusu_id                                           IN NUMBER,
                         nmtar_numero                                       IN NUMBER,
                         vctar_nombre                                       IN VARCHAR2,
                         vctar_fec_exp                                      IN VARCHAR2,
                         nmtar_cod_seg                                      IN NUMBER,
                         vcaud_usuario                                      IN VARCHAR2,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
nmValida  NUMBER;
BEGIN 

	BEGIN
		SELECT COUNT(*)
		  INTO nmValida    
		  FROM DAKERO.TARJETA
		 WHERE TAR_id 	=	nmTAR_id;
	EXCEPTION
	WHEN OTHERS THEN
		nmValida    := 0;
	END;

	IF nmValida= 0 THEN
		vcestado_proceso   := 'N'; 
		vcmensaje_proceso  := 'NUMERO DE TARJETA no encontrado.'; 
		RETURN;
	END IF;

	begin 
		update DAKERO.TARJETA
		set	ttj_id                             	=	nmttj_id,
		   	usu_id                             	=	nmusu_id,
		   	tar_numero                         	=	nmtar_numero,
		   	tar_nombre                         	=	vctar_nombre,
		   	tar_fec_exp                        	=	vctar_fec_exp,
		   	tar_cod_seg                        	=	nmtar_cod_seg,
		   	aud_fecha                          	=	SYSDATE,
		   	aud_usuario                        	=	vcaud_usuario
		where	tar_id                         	=	nmtar_id;
		commit; 
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.TARJETA: '||sqlerrm; 
	end; 
	-- 
end pl_upd_tarjeta;

PROCEDURE pl_del_tarjeta(
                         nmtar_id                                           IN NUMBER,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.TARJETA
	where		tar_id                             	=	nmtar_id;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.TARJETA: '||sqlerrm; 
end pl_del_tarjeta;

PROCEDURE pl_qpk_tarjeta(
                         nmtar_id                                           IN NUMBER,
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TARJETA 
			where	tar_id                         	=	nmtar_id;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TARJETA: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_tarjeta;

PROCEDURE pl_all_tarjeta(
                         csconsulta                                         OUT VCREFCURSOR,
                         vcestado_proceso                                   IN OUT VARCHAR2,
                         vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TARJETA 
			order by tar_id;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TARJETA: '||sqlerrm; 
	end; 
	-- 
end pl_all_tarjeta;


 PROCEDURE pl_ins_servicios(
                           nmsrv_id                                           IN OUT NUMBER,
                           vcsrv_nombre                                       IN VARCHAR2,
                           vcsrv_descripcion                                  IN VARCHAR2,
                           dtsrv_fec_vig                                      IN DATE,
                           vcsrv_version                                      IN VARCHAR2,
                           vcaud_usuario                                      IN VARCHAR2,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2) IS 

BEGIN 

SELECT MAX(NVL(SRV_ID,0)+1) INTO nmSRV_ID  FROM DAKERO.SERVICIOS;

	begin 
		insert into DAKERO.SERVICIOS
		( srv_id
		 ,srv_nombre
		 ,srv_descripcion
		 ,srv_fec_vig
		 ,srv_version
		 ,aud_fecha
		 ,aud_usuario
		)values( 
		  nmSRV_ID
		 ,vcsrv_nombre
		 ,vcsrv_descripcion
		 ,dtsrv_fec_vig
		 ,vcsrv_version
		 ,SYSDATE
		 ,vcaud_usuario
		); 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente.'; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.SERVICIOS: '||sqlerrm; 
	end; 
	-- 
end pl_ins_servicios;


PROCEDURE pl_upd_servicios(
                           nmsrv_id                                           IN NUMBER,
                           vcsrv_nombre                                       IN VARCHAR2,
                           vcsrv_descripcion                                  IN VARCHAR2,
                           dtsrv_fec_vig                                      IN DATE,
                           vcsrv_version                                      IN VARCHAR2,
                           vcaud_usuario                                      IN VARCHAR2,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		update DAKERO.SERVICIOS
		set	srv_nombre                         	=	vcsrv_nombre,
		   	srv_descripcion                    	=	vcsrv_descripcion,
		   	srv_fec_vig                        	=	dtsrv_fec_vig,
		   	srv_version                        	=	vcsrv_version,
		   	aud_fecha                          	=	SYSDATE,
		   	aud_usuario                        	=	vcaud_usuario
		where	srv_id                         	=	nmsrv_id;
		commit; 
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.SERVICIOS: '||sqlerrm; 
	end; 
	-- 
end pl_upd_servicios;

PROCEDURE pl_del_servicios(
                           nmsrv_id                                           IN NUMBER,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.SERVICIOS
	where		srv_id                             	=	nmsrv_id;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.SERVICIOS: '||sqlerrm; 
end pl_del_servicios;

PROCEDURE pl_qpk_servicios(
                           nmsrv_id                                           IN NUMBER,
                           csconsulta                                         OUT VCREFCURSOR,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.SERVICIOS 
			where	srv_id                         	=	nmsrv_id;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.SERVICIOS: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_servicios;

PROCEDURE pl_all_servicios(
                           csconsulta                                         OUT VCREFCURSOR,
                           vcestado_proceso                                   IN OUT VARCHAR2,
                           vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.SERVICIOS 
			order by srv_id;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.SERVICIOS: '||sqlerrm; 
	end; 
	-- 
end pl_all_servicios;


 PROCEDURE pl_ins_token(
                       nmtkn_id                                           IN OUT NUMBER,
                       nmusu_id                                           IN NUMBER,
                       vctkn_token                                        IN VARCHAR2,
                       dttkn_fec_vig                                      IN DATE,
                       vcaud_usuario                                      IN VARCHAR2,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2) IS 

BEGIN 

SELECT MAX(NVL(TKN_ID,0)+1) INTO nmTKN_ID  FROM DAKERO.TOKEN;

	begin 
		insert into DAKERO.TOKEN
		( tkn_id
		 ,usu_id
		 ,tkn_token
		 ,tkn_fec_vig
		 ,aud_fecha
		 ,aud_usuario
		)values( 
		  nmTKN_ID
		 ,nmusu_id
		 ,vctkn_token
		 ,dttkn_fec_vig
		 ,SYSDATE
		 ,vcaud_usuario
		); 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente.'; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.TOKEN: '||sqlerrm; 
	end; 
	-- 
end pl_ins_token;


PROCEDURE pl_upd_token(
                       nmtkn_id                                           IN NUMBER,
                       nmusu_id                                           IN NUMBER,
                       vctkn_token                                        IN VARCHAR2,
                       dttkn_fec_vig                                      IN DATE,
                       vcaud_usuario                                      IN VARCHAR2,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		update DAKERO.TOKEN
		set	usu_id                             	=	nmusu_id,
		   	tkn_token                          	=	vctkn_token,
		   	tkn_fec_vig                        	=	dttkn_fec_vig,
		   	aud_fecha                          	=	SYSDATE,
		   	aud_usuario                        	=	vcaud_usuario
		where	tkn_id                         	=	nmtkn_id;
		commit; 
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.TOKEN: '||sqlerrm; 
	end; 
	-- 
end pl_upd_token;

PROCEDURE pl_del_token(
                       nmtkn_id                                           IN NUMBER,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.TOKEN
	where		tkn_id                             	=	nmtkn_id;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.TOKEN: '||sqlerrm; 
end pl_del_token;

PROCEDURE pl_qpk_token(
                       nmtkn_id                                           IN NUMBER,
                       csconsulta                                         OUT VCREFCURSOR,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TOKEN 
			where	tkn_id                         	=	nmtkn_id;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TOKEN: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_token;

PROCEDURE pl_all_token(
                       csconsulta                                         OUT VCREFCURSOR,
                       vcestado_proceso                                   IN OUT VARCHAR2,
                       vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.TOKEN 
			order by tkn_id;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.TOKEN: '||sqlerrm; 
	end; 
	-- 
end pl_all_token;


 PROCEDURE pl_ins_servicios_token(
                                 nmsrt_id                                           IN OUT NUMBER,
                                 nmtkn_id                                           IN NUMBER,
                                 nmsrv_id                                           IN NUMBER,
                                 vcsrt_estado                                       IN CHAR,
                                 vcaud_usuario                                      IN VARCHAR2,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2) IS 

BEGIN 

SELECT MAX(NVL(SRT_ID,0)+1) INTO nmSRT_ID  FROM DAKERO.SERVICIOS_TOKEN;

	begin 
		insert into DAKERO.SERVICIOS_TOKEN
		( srt_id
		 ,tkn_id
		 ,srv_id
		 ,srt_estado
		 ,aud_fecha
		 ,aud_usuario
		)values( 
		  nmSRT_ID
		 ,nmtkn_id
		 ,nmsrv_id
		 ,vcsrt_estado
		 ,SYSDATE
		 ,vcaud_usuario
		); 
		commit; 
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro creado satisfactoriamente.'; 
	exception 
		when DUP_VAL_ON_INDEX then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Se está intentando duplicar el registro.'; 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error insertando en DAKERO.SERVICIOS_TOKEN: '||sqlerrm; 
	end; 
	-- 
end pl_ins_servicios_token;


PROCEDURE pl_upd_servicios_token(
                                 nmsrt_id                                           IN NUMBER,
                                 nmtkn_id                                           IN NUMBER,
                                 nmsrv_id                                           IN NUMBER,
                                 vcsrt_estado                                       IN CHAR,
                                 vcaud_usuario                                      IN VARCHAR2,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		update DAKERO.SERVICIOS_TOKEN
		set	tkn_id                             	=	nmtkn_id,
		   	srv_id                             	=	nmsrv_id,
		   	srt_estado                         	=	vcsrt_estado,
		   	aud_fecha                          	=	SYSDATE,
		   	aud_usuario                        	=	vcaud_usuario
		where	srt_id                         	=	nmsrt_id;
		commit; 
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Registro actualizado satisfactoriamente.';
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error actualizando en DAKERO.SERVICIOS_TOKEN: '||sqlerrm; 
	end; 
	-- 
end pl_upd_servicios_token;

PROCEDURE pl_del_servicios_token(
                                 nmsrt_id                                           IN NUMBER,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	delete DAKERO.SERVICIOS_TOKEN
	where		srt_id                             	=	nmsrt_id;
	commit;
	--
	vcestado_proceso     := 'S'; 
	vcmensaje_proceso    := 'Registro eliminado satisfactoriamente.'; 
exception 
	when others then 
		--
		if(sqlcode = -02292)then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'No se puede eliminar  el registro porque tiene registros hijos asociados.'; 
			return; 
		end if; 
		--
		vcestado_proceso     := 'N'; 
		vcmensaje_proceso    := 'Error eliminando en DAKERO.SERVICIOS_TOKEN: '||sqlerrm; 
end pl_del_servicios_token;

PROCEDURE pl_qpk_servicios_token(
                                 nmsrt_id                                           IN NUMBER,
                                 csconsulta                                         OUT VCREFCURSOR,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.SERVICIOS_TOKEN 
			where	srt_id                         	=	nmsrt_id;

		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.SERVICIOS_TOKEN: '||sqlerrm; 
	end; 
	-- 
end pl_qpk_servicios_token;

PROCEDURE pl_all_servicios_token(
                                 csconsulta                                         OUT VCREFCURSOR,
                                 vcestado_proceso                                   IN OUT VARCHAR2,
                                 vcmensaje_proceso                                  IN OUT VARCHAR2) IS 
BEGIN 


	begin 
		open csconsulta for 
			select * 
			from DAKERO.SERVICIOS_TOKEN 
			order by srt_id;
		--
		vcestado_proceso     := 'S'; 
		vcmensaje_proceso    := 'Consulta ok'; 
	exception 
		when others then 
			vcestado_proceso     := 'N'; 
			vcmensaje_proceso    := 'Error consultando DAKERO.SERVICIOS_TOKEN: '||sqlerrm; 
	end; 
	-- 
end pl_all_servicios_token;


END QB_CRUD_APLICACION; 
