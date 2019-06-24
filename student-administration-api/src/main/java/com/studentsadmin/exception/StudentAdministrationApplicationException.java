package com.studentsadmin.exception;

public class StudentAdministrationApplicationException extends Exception {
    private String errorCode;
    private String errorMessage;
    private String traceId;
    private String level;
    private String status;

    public static final String GENERIC_ERROR_CODE = "400";
    public static final String GENERIC_ERROR_LEVEL = "ERROR";

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    /**
     * class for Builder
     */
    public static class Builder {

        private String errorCode;
        private String errorMessage;
        private String traceId;
        private String level;
        private String status;

        /**
         * method to set errorCode
         *
         * @param code - string
         * @return Builder object.
         */
        public Builder errorCode(String code) {
            this.errorCode = code;
            return this;
        }

        /**
         * method to set errorMessage
         *
         * @param message - string
         * @return Builder object.
         */
        public Builder errorMessage(String message) {
            this.errorMessage = message;
            return this;
        }

        /**
         * method to set traceId
         *
         * @param traceId - string
         * @return Builder object.
         */
        public Builder traceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        /**
         * @param level - String
         * @return - Builder
         */
        public Builder level(String level) {
            this.level = level;
            return this;
        }

        public StudentAdministrationApplicationException buildGenericException() {
            StudentAdministrationApplicationException
                    studentAdministrationApplicationException = new StudentAdministrationApplicationException();
            studentAdministrationApplicationException.errorCode = this.errorCode;
            studentAdministrationApplicationException.errorMessage = this.errorMessage;
            studentAdministrationApplicationException.traceId = this.traceId;
            studentAdministrationApplicationException.level = GENERIC_ERROR_LEVEL;
            studentAdministrationApplicationException.status = GENERIC_ERROR_CODE;
            return studentAdministrationApplicationException;
        }
    }

}
