package com.demoapp.bookservice.app;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Optional;
import org.springframework.core.annotation.Order;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.swagger.common.SwaggerPluginSupport;

@Order(SwaggerPluginSupport.SWAGGER_PLUGIN_ORDER + 1000)
public class CustomAnnotationSwaggerPlugin implements OperationBuilderPlugin {

    private TypeResolver typeResolver;

    CustomAnnotationSwaggerPlugin() {
    }

    public CustomAnnotationSwaggerPlugin(TypeResolver typeResolver) {
        this.typeResolver = typeResolver;
    }

    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    @Override
    public void apply(OperationContext opCtx) {
        Optional<CustomAnnotation> annotationOptional = opCtx.findAnnotation(CustomAnnotation.class);

        String currentNotes = opCtx.operationBuilder().build().getNotes();
        currentNotes = currentNotes == null ? "" : currentNotes;

        String notesWithCustomAnnotation = currentNotes + "\r\n";

        if (annotationOptional.isPresent()) {
            CustomAnnotation annotation = annotationOptional.get();
            notesWithCustomAnnotation += "Allowed Token Types: " + annotation.tokenType();
        } else {
            notesWithCustomAnnotation += "Allowed User Types: None";
        }
        opCtx.operationBuilder().notes(notesWithCustomAnnotation);
    }
}