package lyang.puml.utils;

import jakarta.ws.rs.core.CacheControl;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import net.sourceforge.plantuml.SourceStringReader;

public class Puml {
  private static final Date EXPIRES = new Date(Long.MIN_VALUE);

  public static ResponseBuilder renderToResponse(String content, int index) throws IOException {
    CacheControl cacheControl = new CacheControl();
    cacheControl.setNoCache(true);
    return Response.ok(renderToStream(content, index).toByteArray())
        .cacheControl(cacheControl)
        .expires(EXPIRES);
  }

  private static ByteArrayOutputStream renderToStream(String content, int index)
      throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    new SourceStringReader(content).outputImage(outputStream, index);
    return outputStream;
  }
}
