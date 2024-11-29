package pawsitive.pawsitive_BE.global.config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import pawsitive.pawsitive_BE.domain.Adoption;
import pawsitive.pawsitive_BE.domain.Shelter;
import pawsitive.pawsitive_BE.domain.User;
import pawsitive.pawsitive_BE.domain.Volunteer;
import pawsitive.pawsitive_BE.domain.enums.Gender;
import pawsitive.pawsitive_BE.domain.enums.Status;
import pawsitive.pawsitive_BE.repository.AdoptionRepository;
import pawsitive.pawsitive_BE.repository.ShelterRepository;
import pawsitive.pawsitive_BE.repository.UserRepository;
import pawsitive.pawsitive_BE.repository.VolunteerRepository;

@Component
public class DataInitializer {

    private final ShelterRepository shelterRepository;
    private final AdoptionRepository adoptionRepository;
    private final VolunteerRepository volunteerRepository;
    private final UserRepository userRepository;

    public DataInitializer( ShelterRepository shelterRepository, AdoptionRepository adoptionRepository, VolunteerRepository volunteerRepository, UserRepository userRepository) {
        this.shelterRepository = shelterRepository;
        this.adoptionRepository = adoptionRepository;
        this.volunteerRepository = volunteerRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {

        if (userRepository.count() == 0) {
            User user = User.builder()
                    .userId("test123").password( "1234").name("테스트걸").birth( "2000-11-17").phone("010-0000-0000").
                    build();
            userRepository.save(user);
        }


        if (shelterRepository.count() == 0) {
            // Shelter 더미 데이터
            Shelter shelter1 = Shelter.builder()
                    .name("(사)동물권자유너와")
                    .phone("070-8691-0852")
                    .managerName("한다미")
                    .managerPhone("010-9675-6167")
                    .address("부산광역시 사상구 사상로 350 찬희빌딩 2층")
                    .region("경남")
                    .build();

            Shelter shelter2 = Shelter.builder()
                    .name("동물자원과(유기동물보호소)")
                    .phone("061-749-3093")
                    .managerName("장정호")
                    .managerPhone("012-345-6789")
                    .address("전라남도 순천시 승주읍 승주로 628 농업기술센터 동물자원과")
                    .region("전라")
                    .build();

            Shelter shelter3 = Shelter.builder()
                    .name("경기도 도우미견나눔센터")
                    .phone("031-8030-4378")
                    .managerName("배상준")
                    .managerPhone("012-345-6789")
                    .address("경기도 화성시 마도면 마도공단로1길 181-15")
                    .region("경기")
                    .build();

            Shelter shelter4 = Shelter.builder()
                    .name("서초구립 방배유스센터")
                    .phone("02-3487-6161")
                    .managerName("한미나")
                    .managerPhone("012-345-6789")
                    .address("서울특별시 서초구 방배로5길 11 서초구립방배유스센터")
                    .region("서울")
                    .build();

            Shelter shelter5 = Shelter.builder()
                    .name("안다")
                    .phone("010-5512-5513")
                    .managerName("이은주\n")
                    .managerPhone("010-5512-5513")
                    .address("경기도 평택시 오좌동길 47-48 (독곡동, 전원유치원) 1층")
                    .region("경기")
                    .build();

            Shelter shelter6 = Shelter.builder()
                    .name("사천시 동물보호센터")
                    .phone("055-831-3768")
                    .managerName("이사천")
                    .managerPhone("055-831-3768")
                    .address("경상남도 사천시")
                    .region("경남")
                    .build();

            Shelter shelter7 = Shelter.builder()
                    .name("통영시 동물보호센터")
                    .phone("061-749-3093")
                    .managerName("박통영")
                    .managerPhone("055-650-6291")
                    .address("경상남도 통영시")
                    .region("경남")
                    .build();

            Shelter shelter8 = Shelter.builder()
                    .name("옥천시 동물보호센터")
                    .phone("043-730-3685")
                    .managerName("옥천동물병원")
                    .managerPhone("010-8843-8844")
                    .address("충청북도 옥천군")
                    .region("충북")
                    .build();

            shelterRepository.save(shelter1);
            shelterRepository.save(shelter2);
            shelterRepository.save(shelter3);
            shelterRepository.save(shelter4);
            shelterRepository.save(shelter5);
            shelterRepository.save(shelter6);
            shelterRepository.save(shelter7);
            shelterRepository.save(shelter8);



            // Volunteer 더미 데이터
            Volunteer volunteer1 = Volunteer.builder()
                    .title("동물권자유너와 유기견/묘 입양센터 자원봉사 모집 [오전]_11/12/1월")
                    .volunteerDate("2024-11-30")
                    .numberOfStaff(21)
                    .content("(사)동물권자유너와에서 자원봉사 모집을 진행합니다.\n" +
                            "동물을 사랑하는 분들과 평소에 유기 동물에게 관심이 있으신 분들 오셨으면 좋겠습니다.\n" +
                            "자원봉사에 책임감을 가지고 성실히 참여해주실 분만 신청 부탁 드립니다.\n" +
                            "★정기봉사자님도 모집하니 정기봉사 의사가 있으시면 문자주세요!!★\n" +
                            "\n" +
                            "★물림 사고에 대비하여 강아지와 고양이를 갑자기 만지는 행동이나 장난감, 간식 등을 빼앗는 행동은 하지 말아주세요.\n" +
                            "★모든 강아지와 고양이는 물거나 할퀼 수 있으니 주의 바랍니다.\n" +
                            "★강아지 고양이 알레르기가 있는 분은 참석 불가 합니다.\n" +
                            "★ 봉사 시간 내 사진 쵤영은 불가합니다.\n" +
                            "★청소가 끝난 후 사진 촬영 가능\n" +
                            "★청소 도중에 아이들 만지기 금지\n" +
                            "SNS(인스타그램, 블로그, 홈페이지 작성 등) 활용에 능숙한 분이라면 활동 참여 전 미리 말씀해주세요. \n" +
                            "아이들의 입양 홍보를 위한 프로필 제작, 리그램, 블로그 업로드 등의 활동도 함께 진행할 수 있습니다. (정기 봉사)\n" +
                            "\n" +
                            "★★★1365에서 신청이 되셨다면 신청하신 날짜에 오시면 됩니다.★★★\n" +
                            "★★★별도 연락이 안 가더라도 정상 신청 된 것이니 봉사 참석해주세요!! ★★★\n" +
                            "★★★활동 취소의 경우 최소 2일 전 취소 연락 바랍니다(이름/취소 날짜/시간) 문자로★★★\n" +
                            "★★★당일 취소 및 미참석은 추후 신청 불가★★★\n" +
                            " \n" +
                            "1. 활동 일자 : 2024.10.01~-11.30  월,목,토 상시 모집\n" +
                            "2. 모집 인원 : 일 4명\n" +
                            "3. 활동 내용 : 유기견,유기묘 배변 청소 / 후원 물품 정리 / 간식 및 놀이 / 산책\n" +
                            "4. 활동 시간 : 10시~14시 (4시간)\n" +
                            "5. 문의 사항 : ☎ 010-9675-6167 (활동 신청 및 문의 사항은 해당 번호로 문자 바랍니다.)\n" +
                            "6. 위치         : 사상구 덕포동 388-5 찬희빌딩 2층(베스트줄눈 건물 2층) \n" +
                            "\n" +
                            "- 청소하기 편한 복장 착용 (긴팔, 긴 바지 착용 권장).\n" +
                            "- 활동 전 안내 연락을 드리므로 반드시 정확한 번호 기입 부탁드립니다.")
                    .startTime("10:00")
                    .endTime("14:00")
                    .status(Status.OPEN)
                    .shelter(shelter1)
                    .build();

            Volunteer volunteer2 = Volunteer.builder()
                    .title("순천시 유기동물 보호소 자원봉사")
                    .volunteerDate("2025-01-31")
                    .numberOfStaff(4)
                    .content("-봉사활동에 필요한 물품은 봉사자가 사전 준비, 지참 필수\n" +
                            "-전염병 예방과 안전을 위해 위생복(방역,방진복),고무장화나 운동화, 고무장갑, 마스크 사전에 준비 지참\n" +
                            "-코로나 예방 체온측정 , 손소독 등 실시\n" +
                            "-안전사고 예방을 위해 위험한 행동, 개인행동 등 금지\n" +
                            "-보호소 관리자의 동의(승인)없이 사료나 간식 급여 불가\n" +
                            "-한 개체를 만지고 다른 개체를 만질 경우 손소독 필수 (유기견을 만질때 관리자동의 없이 만질수없음)\n" +
                            "-보호소내 관리자나 봉사간의 대화 녹취(녹음)또는 촬영 등 금지 사전에 봉호자 컨테이너에 핸드폰보관)\n" +
                            "-사용한 모든 건은 소독 및 세척 후 제자리 놓기 엄수\n" +
                            "-보호동물 유실방지와 안전사고 예방을 위해 문단속 규정 준수\n" +
                            "-보호소를 비방, 폄하하거나 기타 관련 내용을 SNS 등에 게시 금지\n" +
                            "-봉사활동후 개인위생수칙을 철저히 준수\n" +
                            "-봉사활동 중지 및 출입 제한(봉사자가 위 사항을 준수하지 않거나 보호소 관리자의 승인범위를 벗어난 행동으로 보호소 운영에 피해가 예상될 경우 등)\n" +
                            "-비오거나 눈이오면 봉사불가\n" +
                            "-코로나 증상및 감기증상 봉사활동 불가, 미용봉사는 사전협의 없이 불가\n" +
                            "-금요일 신청 오후 3시전까지 마감합니다 \n" +
                            "-봉사활동은 미성년자 참여불가  성인만 봉사 참여 가능")
                    .startTime("13:00")
                    .endTime("15:00")
                    .status(Status.OPEN)
                    .shelter(shelter2)
                    .build();

            Volunteer volunteer3 = Volunteer.builder()
                    .title("반려마루 화성. 강아지센터(유기견)관리 주말,공휴일 (오후)")
                    .volunteerDate("2024-12-29")
                    .numberOfStaff(27)
                    .content("자원봉사(유기견돌봄) 안내\n" +
                            "\n" +
                            "· 활동내용 : 동물보호센터 청소, 사료(또는 물) 급여, 보호견 산책 및 사회화활동 등\n" +
                            "· 준비물 : 청소에 적합한 옷과 신발, 동물을 사랑하고 존중하는 마음(필수), 장화(선택)\n" +
                            "· 오시는 길 : 경기도동물보호복지플랫폼 공지사항 또는 첨부파일(오시는길) 참조\n" +
                            "· 신청 후, 별도의 연락이 가지 않습니다. 봉사일에 경기도도우미견나눔센터로 오시면 됩니다.\n" +
                            "· 센터의 원활한 운영을 위해 봉사 시작 전 도착 부탁드립니다.\n" +
                            "· 대리봉사(신청자 대신 다른 분이 봉사)는 불가능합니다.\n" +
                            "· 자원봉사 문의 : 경기도도우미견나눔센터(031-8030-4375) \n" +
                            "  - 상담 가능 시간 : 평일 09:00 ~ 18:00 (점심시간 12:00 ~ 13:00 제외)\n" +
                            "\n" +
                            "· 모집공고 : 매월 셋째 주 월요일에 새로운 모집글 게시\n" +
                            "· 봉사신청 : 1365 자원봉사포털 사이트(전화신청 불가), 월 8회 이내\n" +
                            "  - 월 8회 초과하여 신청 시, 초과하여 신청한 봉사는 자동 취소\n" +
                            "  - 월 8회 초과하여 봉사를 희망하시는 분은 담당자에게 문의 바랍니다.\n" +
                            "  - 봉사 신청시 접수상태로 변경되었다면 봉사 신청날에 맞추어 방문해주시면 됩니다.\n" +
                            "· 봉사승인 : 일주일 단위 \n" +
                            "· 봉사취소 : 봉사 8일 전까지 취소하셔야 불이익(무단결석 처리)이 없습니다.\n" +
                            "            (승인 전) ‘나의 자원봉사’에서 개별 취소 가능\n" +
                            "            (승인 후) 센터 운영시간에 전화로 취소 요청\n" +
                            "· 봉사제한\n" +
                            "  - 무단결석(이에 준하는 봉사취소 포함) : 2개월간 자원봉사 불가\n" +
                            "  - 8일 이전 취소건에 대한 사유증명은 이메일 주소: bsoo12@gg.go.kr 로 사유증명 이메일을 보내주시면 됩니다.\n" +
                            "  - 불성실한 봉사활동 참여 또는 동물보호에 어긋나는 행동을 한 경우 : 2개월 이상 자원봉사 불가\n" +
                            "  - 봉사제한기간에 봉사신청 시 자동취소되며, 자원봉사목적으로 센터 방문 시 귀가 조치합니다.")
                    .startTime("13:00")
                    .endTime("16:00")
                    .status(Status.OPEN)
                    .shelter(shelter3)
                    .build();

            Volunteer volunteer4 = Volunteer.builder()
                    .title("반려마루 화성. 강아지센터(유기견)관리 주말,공휴일 (오전)")
                    .volunteerDate("2024-12-01")
                    .numberOfStaff(81)
                    .content("자원봉사(유기견돌봄) 안내\n" +
                            "\n" +
                            "· 활동내용 : 동물보호센터 청소, 사료(또는 물) 급여, 보호견 산책 및 사회화활동 등\n" +
                            "· 준비물 : 청소에 적합한 옷과 신발, 동물을 사랑하고 존중하는 마음(필수), 장화(선택)\n" +
                            "· 오시는 길 : 경기도동물보호복지플랫폼 공지사항 또는 첨부파일(오시는길) 참조\n" +
                            "· 신청 후, 별도의 연락이 가지 않습니다. 봉사일에 경기도도우미견나눔센터로 오시면 됩니다.\n" +
                            "· 센터의 원활한 운영을 위해 봉사 시작 전 도착 부탁드립니다.\n" +
                            "· 대리봉사(신청자 대신 다른 분이 봉사)는 불가능합니다.\n" +
                            "· 자원봉사 문의 : 경기도도우미견나눔센터(031-8030-4375) \n" +
                            "  - 상담 가능 시간 : 평일 09:00 ~ 18:00 (점심시간 12:00 ~ 13:00 제외)\n" +
                            "\n" +
                            "· 모집공고 : 매월 셋째 주 월요일에 새로운 모집글 게시\n" +
                            "· 봉사신청 : 1365 자원봉사포털 사이트(전화신청 불가), 월 8회 이내\n" +
                            "  - 월 8회 초과하여 신청 시, 초과하여 신청한 봉사는 자동 취소\n" +
                            "  - 월 8회 초과하여 봉사를 희망하시는 분은 담당자에게 문의 바랍니다.\n" +
                            "  - 봉사 신청시 접수상태로 변경되었다면 봉사 신청날에 맞추어 방문해주시면 됩니다.\n" +
                            "· 봉사승인 : 일주일 단위 \n" +
                            "· 봉사취소 : 봉사 8일 전까지 취소하셔야 불이익(무단결석 처리)이 없습니다.\n" +
                            "            (승인 전) ‘나의 자원봉사’에서 개별 취소 가능\n" +
                            "            (승인 후) 센터 운영시간에 전화로 취소 요청\n" +
                            "· 봉사제한\n" +
                            "  - 무단결석(이에 준하는 봉사취소 포함) : 2개월간 자원봉사 불가\n" +
                            "  - 8일 이전 취소건에 대한 사유증명은 이메일 주소: bsoo12@gg.go.kr 로 사유증명 이메일을 보내주시면 됩니다.\n" +
                            "  - 불성실한 봉사활동 참여 또는 동물보호에 어긋나는 행동을 한 경우 : 2개월 이상 자원봉사 불가\n" +
                            "  - 봉사제한기간에 봉사신청 시 자동취소되며, 자원봉사목적으로 센터 방문 시 귀가 조치합니다.")
                    .startTime("10:00")
                    .endTime("12:00")
                    .status(Status.OPEN)
                    .shelter(shelter2)
                    .build();

            Volunteer volunteer5 = Volunteer.builder()
                    .title("유기견 집 짓기 목공예 자원봉사활동")
                    .volunteerDate("2024-12-07")
                    .numberOfStaff(18)
                    .content("[구글폼 신청서까지 최종으로 작성하여야 신청이 인정됩니다.]\n" +
                            "링크 : https://forms.gle/d8CjYhuaCUUkKgnk9\n" +
                            "\n" +
                            "* 일시 : 2024년 12월 7일(토) 14:00~17:00\n" +
                            "* 장소 : 방배유스센터(서초구 방배로 5길 11)\n" +
                            "* 대상 : 14~19세 청소년(중, 고등학생 연령)\n" +
                            "* 내용 : 목재를 활용하여 유기견 집을 제작하는 목공예 봉사활동(완전 초보 가능)\n" +
                            "\n" +
                            "※ 준비물 : 집에서 잘 쓰지 않는 수건이 있다면 1~2개 지참해 주세요. 제작한 물품과 함께 기부할 예정입니다.\n" +
                            "※ 문의 : 070-4858-1840(방배유스센터 예술사업팀 주임 최현경)\n" +
                            "\n" +
                            "[유의사항]\n" +
                            "※ 지각, 태도 등 불성실한 참여 사례 발생 시 봉사활동 시간 미지급\n" +
                            "※ 학교에 봉사활동확인서를 제출 희망할 때는 교육행정정보시스템(NEIS)의 활동시간 인정에 대한 부분은 반드시 사전에 학교담임교사와 상담하고 봉사활동에 참여 권장\n" +
                            "※ 조립, 마감 정도만 진행하며 최대한 안전에 유의할 예정이지만 활동 특성상 안전사고가 발생할 수 있음(전동드릴 사용 예정)\n" +
                            "※ 서초구 관 내 청소년센터로 서초구 청소년이 우선 참여 대상입니다.")
                    .startTime("14:00")
                    .endTime("17:00")
                    .status(Status.OPEN)
                    .shelter(shelter4)
                    .build();

            Volunteer volunteer6 = Volunteer.builder()
                    .title("성인,청소년) 평택 안다동물보호소 유기견 봉사 (견사청소, 강아지산책, 강아지목욕, 입양홍보, 시설보수)")
                    .volunteerDate("2024-11-30")
                    .numberOfStaff(10)
                    .content("평택에 위치하고 있는 안다동물보호소에서 반려동물들을 사랑하는 분들을 기다리고 있습니다.\n" +
                            "\n" +
                            "보다 깔끔하고 청결한 공간에서 지낼 수 있도록 힘써주시거나\n" +
                            "바깥 냄새를 맡으며 스트레스도 풀고 즐거운 추억을 쌓을 수 있도록 도와주신다거나\n" +
                            "꼬질꼬질했던 모습에서 뽀송하고 개운하게 목욕을 해주시거나\n" +
                            "또는 낡아서 부서지고 보수를 해야 하는 부분들에 손길을 뻗어주실 수 있는 분들,\n" +
                            "아이들이 입양 갈 수 있도록 소소한 영상을 담아주실 분들 등\n" +
                            "아이들을 위한 마음을 가지고 봉사활동에 참여해 주신다면 동물보호소 봉사가 처음이시더라도 환영입니다:) \n" +
                            "\n" +
                            "▷봉사활동 준비물품 : 더러워져도 괜찮은 편안한 옷과 신발, 청소할 때 사용하실 장갑, 마스크, (여자분들) 머리끈, 동물을 사랑하는 마음..♥\n" +
                            "\n" +
                            "▷일찍 도착하신 분들은 전원유치원 하얀건물 안이나 앞 마당에서 안내를 도와드릴 선생님을 기다려주시면 감사하겠습니다\n" +
                            "\n" +
                            "\n" +
                            "-봉사내용 : 반려견목욕, 산책, 견사청소, 홍보영상 촬영, 시설보수 등\n" +
                            "*청소년 봉사자는 고등학생 이상 \n" +
                            "\n" +
                            "* 청소년자원봉사자는 봉사활동 전 학교에 봉사시간 인정여부 확인해주세요")
                    .startTime("10:00")
                    .endTime("17:00")
                    .status(Status.OPEN)
                    .shelter(shelter5)
                    .build();

            volunteerRepository.save(volunteer1);
            volunteerRepository.save(volunteer2);
            volunteerRepository.save(volunteer3);
            volunteerRepository.save(volunteer4);
            volunteerRepository.save(volunteer5);
            volunteerRepository.save(volunteer6);

            // Adoption 더미 데이터
            Adoption adoption1 = Adoption.builder()
                    .title("[고양이] 한국 고양이")
                    .description("같은 치즈냥이 아니올시다~ 무늬가 멧돼지 무늬를 닮음!")
                    .type("고양이")
                    .specType("치즈")
                    .gender(Gender.MALE) // Gender 열거형 값
                    .neutering(false)
                    .age("60일 미만")
                    .status(Status.OPEN) // Status 열거형 값
                    .shelter(shelter6) // shelter 설정
                    .build();

            Adoption adoption2 = Adoption.builder()
                    .title("[개] 믹스견")
                    .description("세상 귀여운 믹스견입니다 손덕마을에서 발견했어요")
                    .type("강아지")
                    .specType("믹스견")
                    .gender(Gender.MALE) // Gender 열거형 값
                    .neutering(false)
                    .age("2022년생")
                    .status(Status.OPEN) // Status 열거형 값
                    .shelter(shelter7) // shelter 설정
                    .build();

            Adoption adoption3 = Adoption.builder()
                    .title("[개] 믹스견")
                    .description("세상 귀여운 믹스견입니다 손덕마을에서 발견했어요")
                    .type("강아지")
                    .specType("믹스견")
                    .gender(Gender.MALE) // Gender 열거형 값
                    .neutering(false)
                    .age("2022년생")
                    .status(Status.OPEN) // Status 열거형 값
                    .shelter(shelter8) // shelter 설정
                    .build();

            Adoption adoption4 = Adoption.builder()
                    .title("[고양이] 터키시 앙고라")
                    .description("척추골절, 경계있음. 동남구 병천면 병천 2로 57 (아우내도서관)에서 발견했어요")
                    .type("고양이")
                    .specType("터키시 앙고라")
                    .gender(Gender.FEMALE) // Gender 열거형 값
                    .neutering(false)
                    .age("2021년생")
                    .status(Status.OPEN) // Status 열거형 값
                    .shelter(shelter8) // shelter 설정
                    .build();

            adoptionRepository.save(adoption1);
            adoptionRepository.save(adoption2);
            adoptionRepository.save(adoption3);
            adoptionRepository.save(adoption4);
        }

    }
}
