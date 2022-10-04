package jpa.jpa_study.board.article.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBaseFields is a Querydsl query type for BaseFields
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QBaseFields extends EntityPathBase<BaseFields> {

    private static final long serialVersionUID = -1068915560L;

    public static final QBaseFields baseFields = new QBaseFields("baseFields");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public QBaseFields(String variable) {
        super(BaseFields.class, forVariable(variable));
    }

    public QBaseFields(Path<? extends BaseFields> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBaseFields(PathMetadata metadata) {
        super(BaseFields.class, metadata);
    }

}

