FROM rockylinux/rockylinux:8.4

RUN dnf -y update && \
    dnf -y install java-11-openjdk && \
    yum -y install java-11-openjdk-devel && \
    dnf clean all && \
    rm -rf /var/cache/dnf/*

RUN groupadd -r appuser && useradd --no-log-init -r -g appuser appuser

WORKDIR /app

COPY --chown=appuser:appuser dnsresolve.java .

RUN javac dnsresolve.java && \
    rm dnsresolve.java && \
    chown appuser:appuser dnsresolve.class

USER appuser

HEALTHCHECK CMD curl -f http://localhost:8080 || exit 1

CMD ["java", "dnsresolve"]
