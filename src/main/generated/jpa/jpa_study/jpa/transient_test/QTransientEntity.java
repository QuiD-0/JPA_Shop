package jpa.jpa_study.jpa.transient_test;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTransientEntity is a Querydsl query type for TransientEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTransientEntity extends EntityPathBase<TransientEntity> {

    private static final long serialVersionUID = 1560897013L;

    public static final QTransientEntity transientEntity = new QTransientEntity("transientEntity");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QTransientEntity(String variable) {
        super(TransientEntity.class, forVariable(variable));
    }

    public QTransientEntity(Path<? extends TransientEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTransientEntity(PathMetadata metadata) {
        super(TransientEntity.class, metadata);
    }

}

