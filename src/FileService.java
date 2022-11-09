public class FileService {
        private static FileService instance;

        public static synchronized FileService getInstance() {
            if (instance == null) {
                instance = new FileService();
            }
            return instance;
        }
}

