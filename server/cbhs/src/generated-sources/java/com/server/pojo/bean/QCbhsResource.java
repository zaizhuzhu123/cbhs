package com.server.pojo.bean;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCbhsResource is a Querydsl query type for CbhsResource
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCbhsResource extends EntityPathBase<CbhsResource> {

    private static final long serialVersionUID = -1133935382L;

    public static final QCbhsResource cbhsResource = new QCbhsResource("cbhsResource");

    public final StringPath contentType = createString("contentType");

    public final StringPath filePath = createString("filePath");

    public final NumberPath<Long> fileSize = createNumber("fileSize", Long.class);

    public final NumberPath<Integer> oid = createNumber("oid", Integer.class);

    public final StringPath oldFileName = createString("oldFileName");

    public final NumberPath<Long> opTime = createNumber("opTime", Long.class);

    public final StringPath opTimeStr = createString("opTimeStr");

    public final StringPath opUserName = createString("opUserName");

    public final NumberPath<Integer> opUserOid = createNumber("opUserOid", Integer.class);

    public final StringPath prefix = createString("prefix");

    public final StringPath url = createString("url");

    public QCbhsResource(String variable) {
        super(CbhsResource.class, forVariable(variable));
    }

    public QCbhsResource(Path<? extends CbhsResource> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCbhsResource(PathMetadata metadata) {
        super(CbhsResource.class, metadata);
    }

}

