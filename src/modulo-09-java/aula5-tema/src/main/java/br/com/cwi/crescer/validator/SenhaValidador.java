/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.validator;

import br.com.cwi.crescer.utils.FacesUtils;
import static br.com.cwi.crescer.utils.FacesUtils.getContext;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author cfari
 */
@FacesValidator("senhaValidator")
public class SenhaValidador implements Validator {

    public static final String PADRAO_SENHA = "^(?=.*[0-9])(?=.*[a-z]).{8,}$";

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String senha = value.toString();

        validarPadraoSenha(senha);
        validarConfirmacaoSenha(senha, component);
    }

    private void validarPadraoSenha(String senha) {
        if (senha == null || senha.isEmpty() || !senha.matches(PADRAO_SENHA)) {
            FacesUtils.addErrorMessage("Senha inválida, sua senha deve conter letras e números, e no mínimo 8 dígitos.");
            getContext().validationFailed();
        }
    }

    public void validarConfirmacaoSenha(String senha, UIComponent component) {
        UIInput inputConfirmacaoSenha = (UIInput) component.getAttributes().get("confirmacaoSenha");
        String confirmacao = inputConfirmacaoSenha.getSubmittedValue().toString();

        if (confirmacao == null || confirmacao.isEmpty() || !senha.equals(confirmacao)) {
            FacesUtils.addErrorMessage("Senha deve ser igual a confirmação de senha.");
            getContext().validationFailed();
        }
    }

}
