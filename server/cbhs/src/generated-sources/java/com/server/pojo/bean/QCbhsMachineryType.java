package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsMachineryType is a Querydsl query type for CbhsMachineryType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsMachineryType extends EntityPathBase<CbhsMachineryType> {

    private static final long serialVersionUID = -1666797108L;

    public static final QCbhsMachineryType cbhsMachineryType = new QCbhsMachineryType("cbhsMachineryType");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final BooleanPath status = createBoolean("status");

    public QCbhsMachineryType(String variable) {
        super(CbhsMachineryType.class, forVariable(variable));
    }

    public QCbhsMachineryType(Path<? extends CbhsMachineryType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsMachineryType(PathMetadata metadata) {
        super(CbhsMachineryType.class, metadata);
    }

}

